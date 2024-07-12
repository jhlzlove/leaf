package com.leaf.service.impl;

import com.leaf.constant.LeafConstants;
import com.leaf.domain.LeafUser;
import com.leaf.domain.LeafUserDraft;
import com.leaf.domain.LeafUserTable;
import com.leaf.service.RegisterService;
import org.babyfish.jimmer.ImmutableObjects;
import org.babyfish.jimmer.sql.JSqlClient;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.UUID;

/**
 * @author jhlz
 * @version x.x.x
 */
@Service
public class RegisterServiceImpl implements RegisterService {

    final JSqlClient sqlClient;

    public RegisterServiceImpl(JSqlClient sqlClient) {
        this.sqlClient = sqlClient;
    }

    @Override
    @Transactional
    public boolean register(LeafUser user) {
        LeafUserTable table = LeafUserTable.$;
        List<LeafUser> result = sqlClient.createQuery(table)
                .whereIf(ImmutableObjects.isLoaded(user, user.phone()), table.phone().eq(user.phone()))
                .whereIf(ImmutableObjects.isLoaded(user, user.email()), table.email().eq(user.email()))
                .whereIf(!ObjectUtils.isEmpty(user.username()), table.username().eq(user.username()))
                .select(table)
                .execute();
        if (ObjectUtils.isEmpty(result)) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodePassword = passwordEncoder.encode(user.password());
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            String nickName = ObjectUtils.isEmpty(user.nickName()) ? LeafConstants.LEAF + uuid : user.nickName();
            LeafUser leafUser = LeafUserDraft.$.produce(draft -> {
                        draft.setUsername(user.username());
                        draft.setPassword(encodePassword);
                        draft.setNickName(nickName);
                        draft.applyUserDetail(it -> {
                                    it.setFirstName(user.userDetail().firstName());
                                    it.setLastName(user.userDetail().lastName());
                                }

                        );
                        draft.setDeptList(user.deptList());
                    }
            );
            sqlClient.save(leafUser);
            return true;
        }
        throw new RuntimeException("该手机号或该邮箱以注册！");
    }
}
