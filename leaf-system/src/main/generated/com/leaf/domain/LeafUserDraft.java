package com.leaf.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import java.lang.CloneNotSupportedException;
import java.lang.Cloneable;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.System;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.babyfish.jimmer.CircularReferenceException;
import org.babyfish.jimmer.DraftConsumer;
import org.babyfish.jimmer.ImmutableObjects;
import org.babyfish.jimmer.UnloadedException;
import org.babyfish.jimmer.internal.GeneratedBy;
import org.babyfish.jimmer.jackson.ImmutableModuleRequiredException;
import org.babyfish.jimmer.lang.OldChain;
import org.babyfish.jimmer.meta.ImmutablePropCategory;
import org.babyfish.jimmer.meta.ImmutableType;
import org.babyfish.jimmer.meta.PropId;
import org.babyfish.jimmer.runtime.DraftContext;
import org.babyfish.jimmer.runtime.DraftSpi;
import org.babyfish.jimmer.runtime.ImmutableSpi;
import org.babyfish.jimmer.runtime.Internal;
import org.babyfish.jimmer.runtime.NonSharedList;
import org.babyfish.jimmer.runtime.Visibility;
import org.babyfish.jimmer.sql.ManyToMany;
import org.babyfish.jimmer.sql.ManyToOne;
import org.jetbrains.annotations.Nullable;

@GeneratedBy(
        type = LeafUser.class
)
public interface LeafUserDraft extends LeafUser, BaseEntityDraft {
    LeafUserDraft.Producer $ = Producer.INSTANCE;

    @OldChain
    LeafUserDraft setUserId(long userId);

    @OldChain
    LeafUserDraft setCreateTime(LocalDateTime createTime);

    @OldChain
    LeafUserDraft setUpdateTime(LocalDateTime updateTime);

    @OldChain
    LeafUserDraft setCreateBy(String createBy);

    @OldChain
    LeafUserDraft setUpdateBy(String updateBy);

    @OldChain
    LeafUserDraft setRemark(String remark);

    @OldChain
    LeafUserDraft setUsername(String username);

    @OldChain
    LeafUserDraft setPassword(String password);

    @OldChain
    LeafUserDraft setNickName(String nickName);

    @OldChain
    LeafUserDraft setPhone(String phone);

    @OldChain
    LeafUserDraft setEmail(String email);

    @OldChain
    LeafUserDraft setAvatar(String avatar);

    @OldChain
    LeafUserDraft setLastLoginTime(LocalDate lastLoginTime);

    @OldChain
    LeafUserDraft setStatus(int status);

    @OldChain
    LeafUserDraft setUserDetailId(Long userDetailId);

    @Nullable
    LeafUserDetailDraft userDetail();

    LeafUserDetailDraft userDetail(boolean autoCreate);

    @OldChain
    LeafUserDraft setUserDetail(LeafUserDetail userDetail);

    @OldChain
    LeafUserDraft applyUserDetail(DraftConsumer<LeafUserDetailDraft> block);

    @OldChain
    LeafUserDraft applyUserDetail(LeafUserDetail base, DraftConsumer<LeafUserDetailDraft> block);

    List<LeafDeptDraft> deptList(boolean autoCreate);

    @OldChain
    LeafUserDraft setDeptList(List<LeafDept> deptList);

    @OldChain
    LeafUserDraft addIntoDeptList(DraftConsumer<LeafDeptDraft> block);

    @OldChain
    LeafUserDraft addIntoDeptList(LeafDept base, DraftConsumer<LeafDeptDraft> block);

    class Producer {
        static final Producer INSTANCE = new Producer();

        public static final int SLOT_USER_ID = 5;

        public static final int SLOT_CREATE_TIME = 0;

        public static final int SLOT_UPDATE_TIME = 1;

        public static final int SLOT_CREATE_BY = 2;

        public static final int SLOT_UPDATE_BY = 3;

        public static final int SLOT_REMARK = 4;

        public static final int SLOT_USERNAME = 6;

        public static final int SLOT_PASSWORD = 7;

        public static final int SLOT_NICK_NAME = 8;

        public static final int SLOT_PHONE = 9;

        public static final int SLOT_EMAIL = 10;

        public static final int SLOT_AVATAR = 11;

        public static final int SLOT_LAST_LOGIN_TIME = 12;

        public static final int SLOT_STATUS = 13;

        public static final int SLOT_USER_DETAIL_ID = 14;

        public static final int SLOT_USER_DETAIL = 15;

        public static final int SLOT_DEPT_LIST = 16;

        public static final ImmutableType TYPE = ImmutableType
            .newBuilder(
                "0.8.125",
                LeafUser.class,
                Collections.singleton(BaseEntityDraft.Producer.TYPE),
                (ctx, base) -> new DraftImpl(ctx, (LeafUser)base)
            )
            .redefine("createTime", SLOT_CREATE_TIME)
            .redefine("updateTime", SLOT_UPDATE_TIME)
            .redefine("createBy", SLOT_CREATE_BY)
            .redefine("updateBy", SLOT_UPDATE_BY)
            .redefine("remark", SLOT_REMARK)
            .id(SLOT_USER_ID, "userId", long.class)
            .add(SLOT_USERNAME, "username", ImmutablePropCategory.SCALAR, String.class, false)
            .add(SLOT_PASSWORD, "password", ImmutablePropCategory.SCALAR, String.class, false)
            .add(SLOT_NICK_NAME, "nickName", ImmutablePropCategory.SCALAR, String.class, false)
            .add(SLOT_PHONE, "phone", ImmutablePropCategory.SCALAR, String.class, true)
            .add(SLOT_EMAIL, "email", ImmutablePropCategory.SCALAR, String.class, true)
            .add(SLOT_AVATAR, "avatar", ImmutablePropCategory.SCALAR, String.class, true)
            .add(SLOT_LAST_LOGIN_TIME, "lastLoginTime", ImmutablePropCategory.SCALAR, LocalDate.class, true)
            .add(SLOT_STATUS, "status", ImmutablePropCategory.SCALAR, int.class, false)
            .add(SLOT_USER_DETAIL_ID, "userDetailId", ImmutablePropCategory.SCALAR, Long.class, true)
            .add(SLOT_USER_DETAIL, "userDetail", ManyToOne.class, LeafUserDetail.class, true)
            .add(SLOT_DEPT_LIST, "deptList", ManyToMany.class, LeafDept.class, false)
            .build();

        private Producer() {
        }

        public LeafUser produce(DraftConsumer<LeafUserDraft> block) {
            return produce(null, block);
        }

        public LeafUser produce(LeafUser base, DraftConsumer<LeafUserDraft> block) {
            return (LeafUser)Internal.produce(TYPE, base, block);
        }

        @JsonPropertyOrder({"dummyPropForJacksonError__", "createTime", "updateTime", "createBy", "updateBy", "remark", "userId", "username", "password", "nickName", "phone", "email", "avatar", "lastLoginTime", "status", "userDetailId", "userDetail", "deptList"})
        public abstract interface Implementor extends LeafUser, ImmutableSpi {
            @Override
            default Object __get(PropId prop) {
                int __propIndex = prop.asIndex();
                switch (__propIndex) {
                    case -1:
                    		return __get(prop.asName());
                    case SLOT_CREATE_TIME:
                    		return createTime();
                    case SLOT_UPDATE_TIME:
                    		return updateTime();
                    case SLOT_CREATE_BY:
                    		return createBy();
                    case SLOT_UPDATE_BY:
                    		return updateBy();
                    case SLOT_REMARK:
                    		return remark();
                    case SLOT_USER_ID:
                    		return (Long)userId();
                    case SLOT_USERNAME:
                    		return username();
                    case SLOT_PASSWORD:
                    		return password();
                    case SLOT_NICK_NAME:
                    		return nickName();
                    case SLOT_PHONE:
                    		return phone();
                    case SLOT_EMAIL:
                    		return email();
                    case SLOT_AVATAR:
                    		return avatar();
                    case SLOT_LAST_LOGIN_TIME:
                    		return lastLoginTime();
                    case SLOT_STATUS:
                    		return (Integer)status();
                    case SLOT_USER_DETAIL_ID:
                    		return userDetailId();
                    case SLOT_USER_DETAIL:
                    		return userDetail();
                    case SLOT_DEPT_LIST:
                    		return deptList();
                    default: throw new IllegalArgumentException("Illegal property name for \"com.leaf.domain.LeafUser\": \"" + prop + "\"");
                }
            }

            @Override
            default Object __get(String prop) {
                switch (prop) {
                    case "createTime":
                    		return createTime();
                    case "updateTime":
                    		return updateTime();
                    case "createBy":
                    		return createBy();
                    case "updateBy":
                    		return updateBy();
                    case "remark":
                    		return remark();
                    case "userId":
                    		return (Long)userId();
                    case "username":
                    		return username();
                    case "password":
                    		return password();
                    case "nickName":
                    		return nickName();
                    case "phone":
                    		return phone();
                    case "email":
                    		return email();
                    case "avatar":
                    		return avatar();
                    case "lastLoginTime":
                    		return lastLoginTime();
                    case "status":
                    		return (Integer)status();
                    case "userDetailId":
                    		return userDetailId();
                    case "userDetail":
                    		return userDetail();
                    case "deptList":
                    		return deptList();
                    default: throw new IllegalArgumentException("Illegal property name for \"com.leaf.domain.LeafUser\": \"" + prop + "\"");
                }
            }

            default long getUserId() {
                return userId();
            }

            @Nullable
            default LocalDateTime getCreateTime() {
                return createTime();
            }

            @Nullable
            default LocalDateTime getUpdateTime() {
                return updateTime();
            }

            @Nullable
            default String getCreateBy() {
                return createBy();
            }

            @Nullable
            default String getUpdateBy() {
                return updateBy();
            }

            @Nullable
            default String getRemark() {
                return remark();
            }

            default String getUsername() {
                return username();
            }

            default String getPassword() {
                return password();
            }

            default String getNickName() {
                return nickName();
            }

            @Nullable
            default String getPhone() {
                return phone();
            }

            @Nullable
            default String getEmail() {
                return email();
            }

            @Nullable
            default String getAvatar() {
                return avatar();
            }

            @Nullable
            default LocalDate getLastLoginTime() {
                return lastLoginTime();
            }

            default int getStatus() {
                return status();
            }

            default Long getUserDetailId() {
                return userDetailId();
            }

            @Nullable
            default LeafUserDetail getUserDetail() {
                return userDetail();
            }

            default List<LeafDept> getDeptList() {
                return deptList();
            }

            @Override
            default ImmutableType __type() {
                return TYPE;
            }

            default int getDummyPropForJacksonError__() {
                throw new ImmutableModuleRequiredException();
            }
        }

        private static class Impl implements Implementor, Cloneable, Serializable {
            private Visibility __visibility;

            long __userIdValue;

            boolean __userIdLoaded = false;

            LocalDateTime __createTimeValue;

            boolean __createTimeLoaded = false;

            LocalDateTime __updateTimeValue;

            boolean __updateTimeLoaded = false;

            String __createByValue;

            boolean __createByLoaded = false;

            String __updateByValue;

            boolean __updateByLoaded = false;

            String __remarkValue;

            boolean __remarkLoaded = false;

            String __usernameValue;

            String __passwordValue;

            String __nickNameValue;

            String __phoneValue;

            boolean __phoneLoaded = false;

            String __emailValue;

            boolean __emailLoaded = false;

            String __avatarValue;

            boolean __avatarLoaded = false;

            LocalDate __lastLoginTimeValue;

            boolean __lastLoginTimeLoaded = false;

            int __statusValue;

            boolean __statusLoaded = false;

            LeafUserDetail __userDetailValue;

            boolean __userDetailLoaded = false;

            NonSharedList<LeafDept> __deptListValue;

            Impl() {
                __visibility = Visibility.of(17);
                __visibility.show(SLOT_USER_DETAIL_ID, false);
            }

            @Override
            @JsonIgnore
            public long userId() {
                if (!__userIdLoaded) {
                    throw new UnloadedException(LeafUser.class, "userId");
                }
                return __userIdValue;
            }

            @Override
            @JsonIgnore
            @Nullable
            public LocalDateTime createTime() {
                if (!__createTimeLoaded) {
                    throw new UnloadedException(LeafUser.class, "createTime");
                }
                return __createTimeValue;
            }

            @Override
            @JsonIgnore
            @Nullable
            public LocalDateTime updateTime() {
                if (!__updateTimeLoaded) {
                    throw new UnloadedException(LeafUser.class, "updateTime");
                }
                return __updateTimeValue;
            }

            @Override
            @JsonIgnore
            @Nullable
            public String createBy() {
                if (!__createByLoaded) {
                    throw new UnloadedException(LeafUser.class, "createBy");
                }
                return __createByValue;
            }

            @Override
            @JsonIgnore
            @Nullable
            public String updateBy() {
                if (!__updateByLoaded) {
                    throw new UnloadedException(LeafUser.class, "updateBy");
                }
                return __updateByValue;
            }

            @Override
            @JsonIgnore
            @Nullable
            public String remark() {
                if (!__remarkLoaded) {
                    throw new UnloadedException(LeafUser.class, "remark");
                }
                return __remarkValue;
            }

            @Override
            @JsonIgnore
            public String username() {
                if (__usernameValue == null) {
                    throw new UnloadedException(LeafUser.class, "username");
                }
                return __usernameValue;
            }

            @Override
            @JsonIgnore
            public String password() {
                if (__passwordValue == null) {
                    throw new UnloadedException(LeafUser.class, "password");
                }
                return __passwordValue;
            }

            @Override
            @JsonIgnore
            public String nickName() {
                if (__nickNameValue == null) {
                    throw new UnloadedException(LeafUser.class, "nickName");
                }
                return __nickNameValue;
            }

            @Override
            @JsonIgnore
            @Nullable
            public String phone() {
                if (!__phoneLoaded) {
                    throw new UnloadedException(LeafUser.class, "phone");
                }
                return __phoneValue;
            }

            @Override
            @JsonIgnore
            @Nullable
            public String email() {
                if (!__emailLoaded) {
                    throw new UnloadedException(LeafUser.class, "email");
                }
                return __emailValue;
            }

            @Override
            @JsonIgnore
            @Nullable
            public String avatar() {
                if (!__avatarLoaded) {
                    throw new UnloadedException(LeafUser.class, "avatar");
                }
                return __avatarValue;
            }

            @Override
            @JsonIgnore
            @Nullable
            public LocalDate lastLoginTime() {
                if (!__lastLoginTimeLoaded) {
                    throw new UnloadedException(LeafUser.class, "lastLoginTime");
                }
                return __lastLoginTimeValue;
            }

            @Override
            @JsonIgnore
            public int status() {
                if (!__statusLoaded) {
                    throw new UnloadedException(LeafUser.class, "status");
                }
                return __statusValue;
            }

            @Override
            @JsonIgnore
            @Nullable
            public Long userDetailId() {
                LeafUserDetail __target = userDetail();
                return __target != null ? __target.userDetailId() : null;
            }

            @Override
            @JsonIgnore
            @Nullable
            public LeafUserDetail userDetail() {
                if (!__userDetailLoaded) {
                    throw new UnloadedException(LeafUser.class, "userDetail");
                }
                return __userDetailValue;
            }

            @Override
            @JsonIgnore
            public List<LeafDept> deptList() {
                if (__deptListValue == null) {
                    throw new UnloadedException(LeafUser.class, "deptList");
                }
                return __deptListValue;
            }

            @Override
            public Impl clone() {
                try {
                    return (Impl)super.clone();
                } catch(CloneNotSupportedException ex) {
                    throw new AssertionError(ex);
                }
            }

            @Override
            public boolean __isLoaded(PropId prop) {
                int __propIndex = prop.asIndex();
                switch (__propIndex) {
                    case -1:
                    		return __isLoaded(prop.asName());
                    case SLOT_CREATE_TIME:
                    		return __createTimeLoaded;
                    case SLOT_UPDATE_TIME:
                    		return __updateTimeLoaded;
                    case SLOT_CREATE_BY:
                    		return __createByLoaded;
                    case SLOT_UPDATE_BY:
                    		return __updateByLoaded;
                    case SLOT_REMARK:
                    		return __remarkLoaded;
                    case SLOT_USER_ID:
                    		return __userIdLoaded;
                    case SLOT_USERNAME:
                    		return __usernameValue != null;
                    case SLOT_PASSWORD:
                    		return __passwordValue != null;
                    case SLOT_NICK_NAME:
                    		return __nickNameValue != null;
                    case SLOT_PHONE:
                    		return __phoneLoaded;
                    case SLOT_EMAIL:
                    		return __emailLoaded;
                    case SLOT_AVATAR:
                    		return __avatarLoaded;
                    case SLOT_LAST_LOGIN_TIME:
                    		return __lastLoginTimeLoaded;
                    case SLOT_STATUS:
                    		return __statusLoaded;
                    case SLOT_USER_DETAIL_ID:
                    		return __isLoaded(PropId.byIndex(SLOT_USER_DETAIL)) && (userDetail() == null || 
                            	((ImmutableSpi)userDetail()).__isLoaded(PropId.byIndex(LeafUserDetailDraft.Producer.SLOT_USER_DETAIL_ID)));
                    case SLOT_USER_DETAIL:
                    		return __userDetailLoaded;
                    case SLOT_DEPT_LIST:
                    		return __deptListValue != null;
                    default: throw new IllegalArgumentException("Illegal property name for \"com.leaf.domain.LeafUser\": \"" + prop + "\"");
                }
            }

            @Override
            public boolean __isLoaded(String prop) {
                switch (prop) {
                    case "createTime":
                    		return __createTimeLoaded;
                    case "updateTime":
                    		return __updateTimeLoaded;
                    case "createBy":
                    		return __createByLoaded;
                    case "updateBy":
                    		return __updateByLoaded;
                    case "remark":
                    		return __remarkLoaded;
                    case "userId":
                    		return __userIdLoaded;
                    case "username":
                    		return __usernameValue != null;
                    case "password":
                    		return __passwordValue != null;
                    case "nickName":
                    		return __nickNameValue != null;
                    case "phone":
                    		return __phoneLoaded;
                    case "email":
                    		return __emailLoaded;
                    case "avatar":
                    		return __avatarLoaded;
                    case "lastLoginTime":
                    		return __lastLoginTimeLoaded;
                    case "status":
                    		return __statusLoaded;
                    case "userDetailId":
                    		return __isLoaded(PropId.byIndex(SLOT_USER_DETAIL)) && (userDetail() == null || 
                            	((ImmutableSpi)userDetail()).__isLoaded(PropId.byIndex(LeafUserDetailDraft.Producer.SLOT_USER_DETAIL_ID)));
                    case "userDetail":
                    		return __userDetailLoaded;
                    case "deptList":
                    		return __deptListValue != null;
                    default: throw new IllegalArgumentException("Illegal property name for \"com.leaf.domain.LeafUser\": \"" + prop + "\"");
                }
            }

            @Override
            public boolean __isVisible(PropId prop) {
                if (__visibility == null) {
                    return true;
                }
                int __propIndex = prop.asIndex();
                switch (__propIndex) {
                    case -1:
                    		return __isVisible(prop.asName());
                    case SLOT_CREATE_TIME:
                    		return __visibility.visible(SLOT_CREATE_TIME);
                    case SLOT_UPDATE_TIME:
                    		return __visibility.visible(SLOT_UPDATE_TIME);
                    case SLOT_CREATE_BY:
                    		return __visibility.visible(SLOT_CREATE_BY);
                    case SLOT_UPDATE_BY:
                    		return __visibility.visible(SLOT_UPDATE_BY);
                    case SLOT_REMARK:
                    		return __visibility.visible(SLOT_REMARK);
                    case SLOT_USER_ID:
                    		return __visibility.visible(SLOT_USER_ID);
                    case SLOT_USERNAME:
                    		return __visibility.visible(SLOT_USERNAME);
                    case SLOT_PASSWORD:
                    		return __visibility.visible(SLOT_PASSWORD);
                    case SLOT_NICK_NAME:
                    		return __visibility.visible(SLOT_NICK_NAME);
                    case SLOT_PHONE:
                    		return __visibility.visible(SLOT_PHONE);
                    case SLOT_EMAIL:
                    		return __visibility.visible(SLOT_EMAIL);
                    case SLOT_AVATAR:
                    		return __visibility.visible(SLOT_AVATAR);
                    case SLOT_LAST_LOGIN_TIME:
                    		return __visibility.visible(SLOT_LAST_LOGIN_TIME);
                    case SLOT_STATUS:
                    		return __visibility.visible(SLOT_STATUS);
                    case SLOT_USER_DETAIL_ID:
                    		return __visibility.visible(SLOT_USER_DETAIL_ID);
                    case SLOT_USER_DETAIL:
                    		return __visibility.visible(SLOT_USER_DETAIL);
                    case SLOT_DEPT_LIST:
                    		return __visibility.visible(SLOT_DEPT_LIST);
                    default: return true;
                }
            }

            @Override
            public boolean __isVisible(String prop) {
                if (__visibility == null) {
                    return true;
                }
                switch (prop) {
                    case "createTime":
                    		return __visibility.visible(SLOT_CREATE_TIME);
                    case "updateTime":
                    		return __visibility.visible(SLOT_UPDATE_TIME);
                    case "createBy":
                    		return __visibility.visible(SLOT_CREATE_BY);
                    case "updateBy":
                    		return __visibility.visible(SLOT_UPDATE_BY);
                    case "remark":
                    		return __visibility.visible(SLOT_REMARK);
                    case "userId":
                    		return __visibility.visible(SLOT_USER_ID);
                    case "username":
                    		return __visibility.visible(SLOT_USERNAME);
                    case "password":
                    		return __visibility.visible(SLOT_PASSWORD);
                    case "nickName":
                    		return __visibility.visible(SLOT_NICK_NAME);
                    case "phone":
                    		return __visibility.visible(SLOT_PHONE);
                    case "email":
                    		return __visibility.visible(SLOT_EMAIL);
                    case "avatar":
                    		return __visibility.visible(SLOT_AVATAR);
                    case "lastLoginTime":
                    		return __visibility.visible(SLOT_LAST_LOGIN_TIME);
                    case "status":
                    		return __visibility.visible(SLOT_STATUS);
                    case "userDetailId":
                    		return __visibility.visible(SLOT_USER_DETAIL_ID);
                    case "userDetail":
                    		return __visibility.visible(SLOT_USER_DETAIL);
                    case "deptList":
                    		return __visibility.visible(SLOT_DEPT_LIST);
                    default: return true;
                }
            }

            @Override
            public int hashCode() {
                int hash = __visibility != null ? __visibility.hashCode() : 0;
                if (__userIdLoaded) {
                    hash = 31 * hash + Long.hashCode(__userIdValue);
                    // If entity-id is loaded, return directly
                    return hash;
                }
                if (__createTimeLoaded && __createTimeValue != null) {
                    hash = 31 * hash + __createTimeValue.hashCode();
                }
                if (__updateTimeLoaded && __updateTimeValue != null) {
                    hash = 31 * hash + __updateTimeValue.hashCode();
                }
                if (__createByLoaded && __createByValue != null) {
                    hash = 31 * hash + __createByValue.hashCode();
                }
                if (__updateByLoaded && __updateByValue != null) {
                    hash = 31 * hash + __updateByValue.hashCode();
                }
                if (__remarkLoaded && __remarkValue != null) {
                    hash = 31 * hash + __remarkValue.hashCode();
                }
                if (__usernameValue != null) {
                    hash = 31 * hash + __usernameValue.hashCode();
                }
                if (__passwordValue != null) {
                    hash = 31 * hash + __passwordValue.hashCode();
                }
                if (__nickNameValue != null) {
                    hash = 31 * hash + __nickNameValue.hashCode();
                }
                if (__phoneLoaded && __phoneValue != null) {
                    hash = 31 * hash + __phoneValue.hashCode();
                }
                if (__emailLoaded && __emailValue != null) {
                    hash = 31 * hash + __emailValue.hashCode();
                }
                if (__avatarLoaded && __avatarValue != null) {
                    hash = 31 * hash + __avatarValue.hashCode();
                }
                if (__lastLoginTimeLoaded && __lastLoginTimeValue != null) {
                    hash = 31 * hash + __lastLoginTimeValue.hashCode();
                }
                if (__statusLoaded) {
                    hash = 31 * hash + Integer.hashCode(__statusValue);
                }
                if (__userDetailLoaded && __userDetailValue != null) {
                    hash = 31 * hash + __userDetailValue.hashCode();
                }
                if (__deptListValue != null) {
                    hash = 31 * hash + __deptListValue.hashCode();
                }
                return hash;
            }

            private int __shallowHashCode() {
                int hash = __visibility != null ? __visibility.hashCode() : 0;
                if (__userIdLoaded) {
                    hash = 31 * hash + Long.hashCode(__userIdValue);
                }
                if (__createTimeLoaded) {
                    hash = 31 * hash + System.identityHashCode(__createTimeValue);
                }
                if (__updateTimeLoaded) {
                    hash = 31 * hash + System.identityHashCode(__updateTimeValue);
                }
                if (__createByLoaded) {
                    hash = 31 * hash + System.identityHashCode(__createByValue);
                }
                if (__updateByLoaded) {
                    hash = 31 * hash + System.identityHashCode(__updateByValue);
                }
                if (__remarkLoaded) {
                    hash = 31 * hash + System.identityHashCode(__remarkValue);
                }
                if (__usernameValue != null) {
                    hash = 31 * hash + System.identityHashCode(__usernameValue);
                }
                if (__passwordValue != null) {
                    hash = 31 * hash + System.identityHashCode(__passwordValue);
                }
                if (__nickNameValue != null) {
                    hash = 31 * hash + System.identityHashCode(__nickNameValue);
                }
                if (__phoneLoaded) {
                    hash = 31 * hash + System.identityHashCode(__phoneValue);
                }
                if (__emailLoaded) {
                    hash = 31 * hash + System.identityHashCode(__emailValue);
                }
                if (__avatarLoaded) {
                    hash = 31 * hash + System.identityHashCode(__avatarValue);
                }
                if (__lastLoginTimeLoaded) {
                    hash = 31 * hash + System.identityHashCode(__lastLoginTimeValue);
                }
                if (__statusLoaded) {
                    hash = 31 * hash + Integer.hashCode(__statusValue);
                }
                if (__userDetailLoaded) {
                    hash = 31 * hash + System.identityHashCode(__userDetailValue);
                }
                if (__deptListValue != null) {
                    hash = 31 * hash + System.identityHashCode(__deptListValue);
                }
                return hash;
            }

            @Override
            public int __hashCode(boolean shallow) {
                return shallow ? __shallowHashCode() : hashCode();
            }

            @Override
            public boolean equals(Object obj) {
                if (obj == null || !(obj instanceof Implementor)) {
                    return false;
                }
                Implementor __other = (Implementor)obj;
                if (__isVisible(PropId.byIndex(SLOT_USER_ID)) != __other.__isVisible(PropId.byIndex(SLOT_USER_ID))) {
                    return false;
                }
                boolean __userIdLoaded = this.__userIdLoaded;
                if (__userIdLoaded != __other.__isLoaded(PropId.byIndex(SLOT_USER_ID))) {
                    return false;
                }
                if (__userIdLoaded) {
                    // If entity-id is loaded, return directly
                    return __userIdValue == __other.userId();
                }
                if (__isVisible(PropId.byIndex(SLOT_CREATE_TIME)) != __other.__isVisible(PropId.byIndex(SLOT_CREATE_TIME))) {
                    return false;
                }
                boolean __createTimeLoaded = this.__createTimeLoaded;
                if (__createTimeLoaded != __other.__isLoaded(PropId.byIndex(SLOT_CREATE_TIME))) {
                    return false;
                }
                if (__createTimeLoaded && !Objects.equals(__createTimeValue, __other.createTime())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_UPDATE_TIME)) != __other.__isVisible(PropId.byIndex(SLOT_UPDATE_TIME))) {
                    return false;
                }
                boolean __updateTimeLoaded = this.__updateTimeLoaded;
                if (__updateTimeLoaded != __other.__isLoaded(PropId.byIndex(SLOT_UPDATE_TIME))) {
                    return false;
                }
                if (__updateTimeLoaded && !Objects.equals(__updateTimeValue, __other.updateTime())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_CREATE_BY)) != __other.__isVisible(PropId.byIndex(SLOT_CREATE_BY))) {
                    return false;
                }
                boolean __createByLoaded = this.__createByLoaded;
                if (__createByLoaded != __other.__isLoaded(PropId.byIndex(SLOT_CREATE_BY))) {
                    return false;
                }
                if (__createByLoaded && !Objects.equals(__createByValue, __other.createBy())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_UPDATE_BY)) != __other.__isVisible(PropId.byIndex(SLOT_UPDATE_BY))) {
                    return false;
                }
                boolean __updateByLoaded = this.__updateByLoaded;
                if (__updateByLoaded != __other.__isLoaded(PropId.byIndex(SLOT_UPDATE_BY))) {
                    return false;
                }
                if (__updateByLoaded && !Objects.equals(__updateByValue, __other.updateBy())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_REMARK)) != __other.__isVisible(PropId.byIndex(SLOT_REMARK))) {
                    return false;
                }
                boolean __remarkLoaded = this.__remarkLoaded;
                if (__remarkLoaded != __other.__isLoaded(PropId.byIndex(SLOT_REMARK))) {
                    return false;
                }
                if (__remarkLoaded && !Objects.equals(__remarkValue, __other.remark())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_USERNAME)) != __other.__isVisible(PropId.byIndex(SLOT_USERNAME))) {
                    return false;
                }
                boolean __usernameLoaded = __usernameValue != null;
                if (__usernameLoaded != __other.__isLoaded(PropId.byIndex(SLOT_USERNAME))) {
                    return false;
                }
                if (__usernameLoaded && !Objects.equals(__usernameValue, __other.username())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_PASSWORD)) != __other.__isVisible(PropId.byIndex(SLOT_PASSWORD))) {
                    return false;
                }
                boolean __passwordLoaded = __passwordValue != null;
                if (__passwordLoaded != __other.__isLoaded(PropId.byIndex(SLOT_PASSWORD))) {
                    return false;
                }
                if (__passwordLoaded && !Objects.equals(__passwordValue, __other.password())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_NICK_NAME)) != __other.__isVisible(PropId.byIndex(SLOT_NICK_NAME))) {
                    return false;
                }
                boolean __nickNameLoaded = __nickNameValue != null;
                if (__nickNameLoaded != __other.__isLoaded(PropId.byIndex(SLOT_NICK_NAME))) {
                    return false;
                }
                if (__nickNameLoaded && !Objects.equals(__nickNameValue, __other.nickName())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_PHONE)) != __other.__isVisible(PropId.byIndex(SLOT_PHONE))) {
                    return false;
                }
                boolean __phoneLoaded = this.__phoneLoaded;
                if (__phoneLoaded != __other.__isLoaded(PropId.byIndex(SLOT_PHONE))) {
                    return false;
                }
                if (__phoneLoaded && !Objects.equals(__phoneValue, __other.phone())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_EMAIL)) != __other.__isVisible(PropId.byIndex(SLOT_EMAIL))) {
                    return false;
                }
                boolean __emailLoaded = this.__emailLoaded;
                if (__emailLoaded != __other.__isLoaded(PropId.byIndex(SLOT_EMAIL))) {
                    return false;
                }
                if (__emailLoaded && !Objects.equals(__emailValue, __other.email())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_AVATAR)) != __other.__isVisible(PropId.byIndex(SLOT_AVATAR))) {
                    return false;
                }
                boolean __avatarLoaded = this.__avatarLoaded;
                if (__avatarLoaded != __other.__isLoaded(PropId.byIndex(SLOT_AVATAR))) {
                    return false;
                }
                if (__avatarLoaded && !Objects.equals(__avatarValue, __other.avatar())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_LAST_LOGIN_TIME)) != __other.__isVisible(PropId.byIndex(SLOT_LAST_LOGIN_TIME))) {
                    return false;
                }
                boolean __lastLoginTimeLoaded = this.__lastLoginTimeLoaded;
                if (__lastLoginTimeLoaded != __other.__isLoaded(PropId.byIndex(SLOT_LAST_LOGIN_TIME))) {
                    return false;
                }
                if (__lastLoginTimeLoaded && !Objects.equals(__lastLoginTimeValue, __other.lastLoginTime())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_STATUS)) != __other.__isVisible(PropId.byIndex(SLOT_STATUS))) {
                    return false;
                }
                boolean __statusLoaded = this.__statusLoaded;
                if (__statusLoaded != __other.__isLoaded(PropId.byIndex(SLOT_STATUS))) {
                    return false;
                }
                if (__statusLoaded && __statusValue != __other.status()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_USER_DETAIL_ID)) != __other.__isVisible(PropId.byIndex(SLOT_USER_DETAIL_ID))) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_USER_DETAIL)) != __other.__isVisible(PropId.byIndex(SLOT_USER_DETAIL))) {
                    return false;
                }
                boolean __userDetailLoaded = this.__userDetailLoaded;
                if (__userDetailLoaded != __other.__isLoaded(PropId.byIndex(SLOT_USER_DETAIL))) {
                    return false;
                }
                if (__userDetailLoaded && !Objects.equals(__userDetailValue, __other.userDetail())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_DEPT_LIST)) != __other.__isVisible(PropId.byIndex(SLOT_DEPT_LIST))) {
                    return false;
                }
                boolean __deptListLoaded = __deptListValue != null;
                if (__deptListLoaded != __other.__isLoaded(PropId.byIndex(SLOT_DEPT_LIST))) {
                    return false;
                }
                if (__deptListLoaded && !Objects.equals(__deptListValue, __other.deptList())) {
                    return false;
                }
                return true;
            }

            private boolean __shallowEquals(Object obj) {
                if (obj == null || !(obj instanceof Implementor)) {
                    return false;
                }
                Implementor __other = (Implementor)obj;
                if (__isVisible(PropId.byIndex(SLOT_USER_ID)) != __other.__isVisible(PropId.byIndex(SLOT_USER_ID))) {
                    return false;
                }
                boolean __userIdLoaded = this.__userIdLoaded;
                if (__userIdLoaded != __other.__isLoaded(PropId.byIndex(SLOT_USER_ID))) {
                    return false;
                }
                if (__userIdLoaded && __userIdValue != __other.userId()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_CREATE_TIME)) != __other.__isVisible(PropId.byIndex(SLOT_CREATE_TIME))) {
                    return false;
                }
                boolean __createTimeLoaded = this.__createTimeLoaded;
                if (__createTimeLoaded != __other.__isLoaded(PropId.byIndex(SLOT_CREATE_TIME))) {
                    return false;
                }
                if (__createTimeLoaded && __createTimeValue != __other.createTime()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_UPDATE_TIME)) != __other.__isVisible(PropId.byIndex(SLOT_UPDATE_TIME))) {
                    return false;
                }
                boolean __updateTimeLoaded = this.__updateTimeLoaded;
                if (__updateTimeLoaded != __other.__isLoaded(PropId.byIndex(SLOT_UPDATE_TIME))) {
                    return false;
                }
                if (__updateTimeLoaded && __updateTimeValue != __other.updateTime()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_CREATE_BY)) != __other.__isVisible(PropId.byIndex(SLOT_CREATE_BY))) {
                    return false;
                }
                boolean __createByLoaded = this.__createByLoaded;
                if (__createByLoaded != __other.__isLoaded(PropId.byIndex(SLOT_CREATE_BY))) {
                    return false;
                }
                if (__createByLoaded && __createByValue != __other.createBy()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_UPDATE_BY)) != __other.__isVisible(PropId.byIndex(SLOT_UPDATE_BY))) {
                    return false;
                }
                boolean __updateByLoaded = this.__updateByLoaded;
                if (__updateByLoaded != __other.__isLoaded(PropId.byIndex(SLOT_UPDATE_BY))) {
                    return false;
                }
                if (__updateByLoaded && __updateByValue != __other.updateBy()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_REMARK)) != __other.__isVisible(PropId.byIndex(SLOT_REMARK))) {
                    return false;
                }
                boolean __remarkLoaded = this.__remarkLoaded;
                if (__remarkLoaded != __other.__isLoaded(PropId.byIndex(SLOT_REMARK))) {
                    return false;
                }
                if (__remarkLoaded && __remarkValue != __other.remark()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_USERNAME)) != __other.__isVisible(PropId.byIndex(SLOT_USERNAME))) {
                    return false;
                }
                boolean __usernameLoaded = __usernameValue != null;
                if (__usernameLoaded != __other.__isLoaded(PropId.byIndex(SLOT_USERNAME))) {
                    return false;
                }
                if (__usernameLoaded && __usernameValue != __other.username()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_PASSWORD)) != __other.__isVisible(PropId.byIndex(SLOT_PASSWORD))) {
                    return false;
                }
                boolean __passwordLoaded = __passwordValue != null;
                if (__passwordLoaded != __other.__isLoaded(PropId.byIndex(SLOT_PASSWORD))) {
                    return false;
                }
                if (__passwordLoaded && __passwordValue != __other.password()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_NICK_NAME)) != __other.__isVisible(PropId.byIndex(SLOT_NICK_NAME))) {
                    return false;
                }
                boolean __nickNameLoaded = __nickNameValue != null;
                if (__nickNameLoaded != __other.__isLoaded(PropId.byIndex(SLOT_NICK_NAME))) {
                    return false;
                }
                if (__nickNameLoaded && __nickNameValue != __other.nickName()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_PHONE)) != __other.__isVisible(PropId.byIndex(SLOT_PHONE))) {
                    return false;
                }
                boolean __phoneLoaded = this.__phoneLoaded;
                if (__phoneLoaded != __other.__isLoaded(PropId.byIndex(SLOT_PHONE))) {
                    return false;
                }
                if (__phoneLoaded && __phoneValue != __other.phone()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_EMAIL)) != __other.__isVisible(PropId.byIndex(SLOT_EMAIL))) {
                    return false;
                }
                boolean __emailLoaded = this.__emailLoaded;
                if (__emailLoaded != __other.__isLoaded(PropId.byIndex(SLOT_EMAIL))) {
                    return false;
                }
                if (__emailLoaded && __emailValue != __other.email()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_AVATAR)) != __other.__isVisible(PropId.byIndex(SLOT_AVATAR))) {
                    return false;
                }
                boolean __avatarLoaded = this.__avatarLoaded;
                if (__avatarLoaded != __other.__isLoaded(PropId.byIndex(SLOT_AVATAR))) {
                    return false;
                }
                if (__avatarLoaded && __avatarValue != __other.avatar()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_LAST_LOGIN_TIME)) != __other.__isVisible(PropId.byIndex(SLOT_LAST_LOGIN_TIME))) {
                    return false;
                }
                boolean __lastLoginTimeLoaded = this.__lastLoginTimeLoaded;
                if (__lastLoginTimeLoaded != __other.__isLoaded(PropId.byIndex(SLOT_LAST_LOGIN_TIME))) {
                    return false;
                }
                if (__lastLoginTimeLoaded && __lastLoginTimeValue != __other.lastLoginTime()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_STATUS)) != __other.__isVisible(PropId.byIndex(SLOT_STATUS))) {
                    return false;
                }
                boolean __statusLoaded = this.__statusLoaded;
                if (__statusLoaded != __other.__isLoaded(PropId.byIndex(SLOT_STATUS))) {
                    return false;
                }
                if (__statusLoaded && __statusValue != __other.status()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_USER_DETAIL_ID)) != __other.__isVisible(PropId.byIndex(SLOT_USER_DETAIL_ID))) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_USER_DETAIL)) != __other.__isVisible(PropId.byIndex(SLOT_USER_DETAIL))) {
                    return false;
                }
                boolean __userDetailLoaded = this.__userDetailLoaded;
                if (__userDetailLoaded != __other.__isLoaded(PropId.byIndex(SLOT_USER_DETAIL))) {
                    return false;
                }
                if (__userDetailLoaded && __userDetailValue != __other.userDetail()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_DEPT_LIST)) != __other.__isVisible(PropId.byIndex(SLOT_DEPT_LIST))) {
                    return false;
                }
                boolean __deptListLoaded = __deptListValue != null;
                if (__deptListLoaded != __other.__isLoaded(PropId.byIndex(SLOT_DEPT_LIST))) {
                    return false;
                }
                if (__deptListLoaded && __deptListValue != __other.deptList()) {
                    return false;
                }
                return true;
            }

            @Override
            public boolean __equals(Object obj, boolean shallow) {
                return shallow ? __shallowEquals(obj) : equals(obj);
            }

            @Override
            public String toString() {
                return ImmutableObjects.toString(this);
            }
        }

        private static class DraftImpl implements Implementor, DraftSpi, LeafUserDraft {
            private DraftContext __ctx;

            private Impl __base;

            private Impl __modified;

            private boolean __resolving;

            DraftImpl(DraftContext ctx, LeafUser base) {
                __ctx = ctx;
                if (base != null) {
                    __base = (Impl)base;
                }
                else {
                    __modified = new Impl();
                }
            }

            @Override
            public boolean __isLoaded(PropId prop) {
                return (__modified!= null ? __modified : __base).__isLoaded(prop);
            }

            @Override
            public boolean __isLoaded(String prop) {
                return (__modified!= null ? __modified : __base).__isLoaded(prop);
            }

            @Override
            public boolean __isVisible(PropId prop) {
                return (__modified!= null ? __modified : __base).__isVisible(prop);
            }

            @Override
            public boolean __isVisible(String prop) {
                return (__modified!= null ? __modified : __base).__isVisible(prop);
            }

            @Override
            public int hashCode() {
                return (__modified!= null ? __modified : __base).hashCode();
            }

            @Override
            public int __hashCode(boolean shallow) {
                return (__modified!= null ? __modified : __base).__hashCode(shallow);
            }

            @Override
            public boolean equals(Object obj) {
                return (__modified!= null ? __modified : __base).equals(obj);
            }

            @Override
            public boolean __equals(Object obj, boolean shallow) {
                return (__modified!= null ? __modified : __base).__equals(obj, shallow);
            }

            @Override
            public String toString() {
                return ImmutableObjects.toString((__modified!= null ? __modified : __base));
            }

            @Override
            @JsonIgnore
            public long userId() {
                return (__modified!= null ? __modified : __base).userId();
            }

            @Override
            public LeafUserDraft setUserId(long userId) {
                Impl __tmpModified = __modified();
                __tmpModified.__userIdValue = userId;
                __tmpModified.__userIdLoaded = true;
                return this;
            }

            @Override
            @JsonIgnore
            @Nullable
            public LocalDateTime createTime() {
                return (__modified!= null ? __modified : __base).createTime();
            }

            @Override
            public LeafUserDraft setCreateTime(LocalDateTime createTime) {
                Impl __tmpModified = __modified();
                __tmpModified.__createTimeValue = createTime;
                __tmpModified.__createTimeLoaded = true;
                return this;
            }

            @Override
            @JsonIgnore
            @Nullable
            public LocalDateTime updateTime() {
                return (__modified!= null ? __modified : __base).updateTime();
            }

            @Override
            public LeafUserDraft setUpdateTime(LocalDateTime updateTime) {
                Impl __tmpModified = __modified();
                __tmpModified.__updateTimeValue = updateTime;
                __tmpModified.__updateTimeLoaded = true;
                return this;
            }

            @Override
            @JsonIgnore
            @Nullable
            public String createBy() {
                return (__modified!= null ? __modified : __base).createBy();
            }

            @Override
            public LeafUserDraft setCreateBy(String createBy) {
                Impl __tmpModified = __modified();
                __tmpModified.__createByValue = createBy;
                __tmpModified.__createByLoaded = true;
                return this;
            }

            @Override
            @JsonIgnore
            @Nullable
            public String updateBy() {
                return (__modified!= null ? __modified : __base).updateBy();
            }

            @Override
            public LeafUserDraft setUpdateBy(String updateBy) {
                Impl __tmpModified = __modified();
                __tmpModified.__updateByValue = updateBy;
                __tmpModified.__updateByLoaded = true;
                return this;
            }

            @Override
            @JsonIgnore
            @Nullable
            public String remark() {
                return (__modified!= null ? __modified : __base).remark();
            }

            @Override
            public LeafUserDraft setRemark(String remark) {
                Impl __tmpModified = __modified();
                __tmpModified.__remarkValue = remark;
                __tmpModified.__remarkLoaded = true;
                return this;
            }

            @Override
            @JsonIgnore
            public String username() {
                return (__modified!= null ? __modified : __base).username();
            }

            @Override
            public LeafUserDraft setUsername(String username) {
                if (username == null) {
                    throw new IllegalArgumentException(
                        "'username' cannot be null, please specify non-null value or use nullable annotation to decorate this property"
                    );
                }
                Impl __tmpModified = __modified();
                __tmpModified.__usernameValue = username;
                return this;
            }

            @Override
            @JsonIgnore
            public String password() {
                return (__modified!= null ? __modified : __base).password();
            }

            @Override
            public LeafUserDraft setPassword(String password) {
                if (password == null) {
                    throw new IllegalArgumentException(
                        "'password' cannot be null, please specify non-null value or use nullable annotation to decorate this property"
                    );
                }
                Impl __tmpModified = __modified();
                __tmpModified.__passwordValue = password;
                return this;
            }

            @Override
            @JsonIgnore
            public String nickName() {
                return (__modified!= null ? __modified : __base).nickName();
            }

            @Override
            public LeafUserDraft setNickName(String nickName) {
                if (nickName == null) {
                    throw new IllegalArgumentException(
                        "'nickName' cannot be null, please specify non-null value or use nullable annotation to decorate this property"
                    );
                }
                Impl __tmpModified = __modified();
                __tmpModified.__nickNameValue = nickName;
                return this;
            }

            @Override
            @JsonIgnore
            @Nullable
            public String phone() {
                return (__modified!= null ? __modified : __base).phone();
            }

            @Override
            public LeafUserDraft setPhone(String phone) {
                Impl __tmpModified = __modified();
                __tmpModified.__phoneValue = phone;
                __tmpModified.__phoneLoaded = true;
                return this;
            }

            @Override
            @JsonIgnore
            @Nullable
            public String email() {
                return (__modified!= null ? __modified : __base).email();
            }

            @Override
            public LeafUserDraft setEmail(String email) {
                Impl __tmpModified = __modified();
                __tmpModified.__emailValue = email;
                __tmpModified.__emailLoaded = true;
                return this;
            }

            @Override
            @JsonIgnore
            @Nullable
            public String avatar() {
                return (__modified!= null ? __modified : __base).avatar();
            }

            @Override
            public LeafUserDraft setAvatar(String avatar) {
                Impl __tmpModified = __modified();
                __tmpModified.__avatarValue = avatar;
                __tmpModified.__avatarLoaded = true;
                return this;
            }

            @Override
            @JsonIgnore
            @Nullable
            public LocalDate lastLoginTime() {
                return (__modified!= null ? __modified : __base).lastLoginTime();
            }

            @Override
            public LeafUserDraft setLastLoginTime(LocalDate lastLoginTime) {
                Impl __tmpModified = __modified();
                __tmpModified.__lastLoginTimeValue = lastLoginTime;
                __tmpModified.__lastLoginTimeLoaded = true;
                return this;
            }

            @Override
            @JsonIgnore
            public int status() {
                return (__modified!= null ? __modified : __base).status();
            }

            @Override
            public LeafUserDraft setStatus(int status) {
                Impl __tmpModified = __modified();
                __tmpModified.__statusValue = status;
                __tmpModified.__statusLoaded = true;
                return this;
            }

            @Override
            @JsonIgnore
            @Nullable
            public Long userDetailId() {
                LeafUserDetail __target = userDetail();
                return __target != null ? __target.userDetailId() : null;
            }

            @Override
            public LeafUserDraft setUserDetailId(Long userDetailId) {
                if (userDetailId != null) {
                    setUserDetail(ImmutableObjects.makeIdOnly(LeafUserDetail.class, userDetailId));
                } else {
                    setUserDetail(null);
                }
                return this;
            }

            @Override
            @JsonIgnore
            @Nullable
            public LeafUserDetailDraft userDetail() {
                return __ctx.toDraftObject((__modified!= null ? __modified : __base).userDetail());
            }

            @Override
            public LeafUserDetailDraft userDetail(boolean autoCreate) {
                if (autoCreate && (!__isLoaded(PropId.byIndex(SLOT_USER_DETAIL)) || userDetail() == null)) {
                    setUserDetail(LeafUserDetailDraft.$.produce(null, null));
                }
                return __ctx.toDraftObject((__modified!= null ? __modified : __base).userDetail());
            }

            @Override
            public LeafUserDraft setUserDetail(LeafUserDetail userDetail) {
                Impl __tmpModified = __modified();
                __tmpModified.__userDetailValue = userDetail;
                __tmpModified.__userDetailLoaded = true;
                return this;
            }

            @Override
            public LeafUserDraft applyUserDetail(DraftConsumer<LeafUserDetailDraft> block) {
                applyUserDetail(null, block);
                return this;
            }

            @Override
            public LeafUserDraft applyUserDetail(LeafUserDetail base,
                    DraftConsumer<LeafUserDetailDraft> block) {
                setUserDetail(LeafUserDetailDraft.$.produce(base, block));
                return this;
            }

            @Override
            @JsonIgnore
            public List<LeafDept> deptList() {
                return __ctx.toDraftList((__modified!= null ? __modified : __base).deptList(), LeafDept.class, true);
            }

            @Override
            public List<LeafDeptDraft> deptList(boolean autoCreate) {
                if (autoCreate && (!__isLoaded(PropId.byIndex(SLOT_DEPT_LIST)))) {
                    setDeptList(new ArrayList<>());
                }
                return __ctx.toDraftList((__modified!= null ? __modified : __base).deptList(), LeafDept.class, true);
            }

            @Override
            public LeafUserDraft setDeptList(List<LeafDept> deptList) {
                if (deptList == null) {
                    throw new IllegalArgumentException(
                        "'deptList' cannot be null, please specify non-null value or use nullable annotation to decorate this property"
                    );
                }
                Impl __tmpModified = __modified();
                __tmpModified.__deptListValue = NonSharedList.of(__tmpModified.__deptListValue, deptList);
                return this;
            }

            @Override
            public LeafUserDraft addIntoDeptList(DraftConsumer<LeafDeptDraft> block) {
                addIntoDeptList(null, block);
                return this;
            }

            @Override
            public LeafUserDraft addIntoDeptList(LeafDept base,
                    DraftConsumer<LeafDeptDraft> block) {
                deptList(true).add((LeafDeptDraft)LeafDeptDraft.$.produce(base, block));
                return this;
            }

            @SuppressWarnings("unchecked")
            @Override
            public void __set(PropId prop, Object value) {
                int __propIndex = prop.asIndex();
                switch (__propIndex) {
                    case -1:
                    		__set(prop.asName(), value);
                    return;
                    case SLOT_CREATE_TIME:
                    		setCreateTime((LocalDateTime)value);break;
                    case SLOT_UPDATE_TIME:
                    		setUpdateTime((LocalDateTime)value);break;
                    case SLOT_CREATE_BY:
                    		setCreateBy((String)value);break;
                    case SLOT_UPDATE_BY:
                    		setUpdateBy((String)value);break;
                    case SLOT_REMARK:
                    		setRemark((String)value);break;
                    case SLOT_USER_ID:
                    		if (value == null) throw new IllegalArgumentException("'userId' cannot be null, if you want to set null, please use any annotation whose simple name is \"Nullable\" to decorate the property");
                            setUserId((Long)value);
                            break;
                    case SLOT_USERNAME:
                    		setUsername((String)value);break;
                    case SLOT_PASSWORD:
                    		setPassword((String)value);break;
                    case SLOT_NICK_NAME:
                    		setNickName((String)value);break;
                    case SLOT_PHONE:
                    		setPhone((String)value);break;
                    case SLOT_EMAIL:
                    		setEmail((String)value);break;
                    case SLOT_AVATAR:
                    		setAvatar((String)value);break;
                    case SLOT_LAST_LOGIN_TIME:
                    		setLastLoginTime((LocalDate)value);break;
                    case SLOT_STATUS:
                    		if (value == null) throw new IllegalArgumentException("'status' cannot be null, if you want to set null, please use any annotation whose simple name is \"Nullable\" to decorate the property");
                            setStatus((Integer)value);
                            break;
                    case SLOT_USER_DETAIL_ID:
                    		setUserDetailId((Long)value);break;
                    case SLOT_USER_DETAIL:
                    		setUserDetail((LeafUserDetail)value);break;
                    case SLOT_DEPT_LIST:
                    		setDeptList((List<LeafDept>)value);break;
                    default: throw new IllegalArgumentException("Illegal property id for \"com.leaf.domain.LeafUser\": \"" + prop + "\"");
                }
            }

            @SuppressWarnings("unchecked")
            @Override
            public void __set(String prop, Object value) {
                switch (prop) {
                    case "createTime":
                    		setCreateTime((LocalDateTime)value);break;
                    case "updateTime":
                    		setUpdateTime((LocalDateTime)value);break;
                    case "createBy":
                    		setCreateBy((String)value);break;
                    case "updateBy":
                    		setUpdateBy((String)value);break;
                    case "remark":
                    		setRemark((String)value);break;
                    case "userId":
                    		if (value == null) throw new IllegalArgumentException("'userId' cannot be null, if you want to set null, please use any annotation whose simple name is \"Nullable\" to decorate the property");
                            setUserId((Long)value);
                            break;
                    case "username":
                    		setUsername((String)value);break;
                    case "password":
                    		setPassword((String)value);break;
                    case "nickName":
                    		setNickName((String)value);break;
                    case "phone":
                    		setPhone((String)value);break;
                    case "email":
                    		setEmail((String)value);break;
                    case "avatar":
                    		setAvatar((String)value);break;
                    case "lastLoginTime":
                    		setLastLoginTime((LocalDate)value);break;
                    case "status":
                    		if (value == null) throw new IllegalArgumentException("'status' cannot be null, if you want to set null, please use any annotation whose simple name is \"Nullable\" to decorate the property");
                            setStatus((Integer)value);
                            break;
                    case "userDetailId":
                    		setUserDetailId((Long)value);break;
                    case "userDetail":
                    		setUserDetail((LeafUserDetail)value);break;
                    case "deptList":
                    		setDeptList((List<LeafDept>)value);break;
                    default: throw new IllegalArgumentException("Illegal property name for \"com.leaf.domain.LeafUser\": \"" + prop + "\"");
                }
            }

            @Override
            public void __show(PropId prop, boolean visible) {
                Visibility __visibility = (__modified!= null ? __modified : __base).__visibility;
                if (__visibility == null) {
                    if (visible) {
                        return;
                    }
                    __modified().__visibility = __visibility = Visibility.of(17);
                }
                int __propIndex = prop.asIndex();
                switch (__propIndex) {
                    case -1:
                    		__show(prop.asName(), visible);
                    return;
                    case SLOT_CREATE_TIME:
                    		__visibility.show(SLOT_CREATE_TIME, visible);break;
                    case SLOT_UPDATE_TIME:
                    		__visibility.show(SLOT_UPDATE_TIME, visible);break;
                    case SLOT_CREATE_BY:
                    		__visibility.show(SLOT_CREATE_BY, visible);break;
                    case SLOT_UPDATE_BY:
                    		__visibility.show(SLOT_UPDATE_BY, visible);break;
                    case SLOT_REMARK:
                    		__visibility.show(SLOT_REMARK, visible);break;
                    case SLOT_USER_ID:
                    		__visibility.show(SLOT_USER_ID, visible);break;
                    case SLOT_USERNAME:
                    		__visibility.show(SLOT_USERNAME, visible);break;
                    case SLOT_PASSWORD:
                    		__visibility.show(SLOT_PASSWORD, visible);break;
                    case SLOT_NICK_NAME:
                    		__visibility.show(SLOT_NICK_NAME, visible);break;
                    case SLOT_PHONE:
                    		__visibility.show(SLOT_PHONE, visible);break;
                    case SLOT_EMAIL:
                    		__visibility.show(SLOT_EMAIL, visible);break;
                    case SLOT_AVATAR:
                    		__visibility.show(SLOT_AVATAR, visible);break;
                    case SLOT_LAST_LOGIN_TIME:
                    		__visibility.show(SLOT_LAST_LOGIN_TIME, visible);break;
                    case SLOT_STATUS:
                    		__visibility.show(SLOT_STATUS, visible);break;
                    case SLOT_USER_DETAIL_ID:
                    		__visibility.show(SLOT_USER_DETAIL_ID, visible);break;
                    case SLOT_USER_DETAIL:
                    		__visibility.show(SLOT_USER_DETAIL, visible);break;
                    case SLOT_DEPT_LIST:
                    		__visibility.show(SLOT_DEPT_LIST, visible);break;
                    default: throw new IllegalArgumentException(
                                "Illegal property id for \"com.leaf.domain.LeafUser\": \"" + 
                                prop + 
                                "\",it does not exists"
                            );
                }
            }

            @Override
            public void __show(String prop, boolean visible) {
                Visibility __visibility = (__modified!= null ? __modified : __base).__visibility;
                if (__visibility == null) {
                    if (visible) {
                        return;
                    }
                    __modified().__visibility = __visibility = Visibility.of(17);
                }
                switch (prop) {
                    case "createTime":
                    		__visibility.show(SLOT_CREATE_TIME, visible);break;
                    case "updateTime":
                    		__visibility.show(SLOT_UPDATE_TIME, visible);break;
                    case "createBy":
                    		__visibility.show(SLOT_CREATE_BY, visible);break;
                    case "updateBy":
                    		__visibility.show(SLOT_UPDATE_BY, visible);break;
                    case "remark":
                    		__visibility.show(SLOT_REMARK, visible);break;
                    case "userId":
                    		__visibility.show(SLOT_USER_ID, visible);break;
                    case "username":
                    		__visibility.show(SLOT_USERNAME, visible);break;
                    case "password":
                    		__visibility.show(SLOT_PASSWORD, visible);break;
                    case "nickName":
                    		__visibility.show(SLOT_NICK_NAME, visible);break;
                    case "phone":
                    		__visibility.show(SLOT_PHONE, visible);break;
                    case "email":
                    		__visibility.show(SLOT_EMAIL, visible);break;
                    case "avatar":
                    		__visibility.show(SLOT_AVATAR, visible);break;
                    case "lastLoginTime":
                    		__visibility.show(SLOT_LAST_LOGIN_TIME, visible);break;
                    case "status":
                    		__visibility.show(SLOT_STATUS, visible);break;
                    case "userDetailId":
                    		__visibility.show(SLOT_USER_DETAIL_ID, visible);break;
                    case "userDetail":
                    		__visibility.show(SLOT_USER_DETAIL, visible);break;
                    case "deptList":
                    		__visibility.show(SLOT_DEPT_LIST, visible);break;
                    default: throw new IllegalArgumentException(
                                "Illegal property name for \"com.leaf.domain.LeafUser\": \"" + 
                                prop + 
                                "\",it does not exists"
                            );
                }
            }

            @Override
            public void __unload(PropId prop) {
                int __propIndex = prop.asIndex();
                switch (__propIndex) {
                    case -1:
                    		__unload(prop.asName());
                    return;
                    case SLOT_CREATE_TIME:
                    		__modified().__createTimeLoaded = false;break;
                    case SLOT_UPDATE_TIME:
                    		__modified().__updateTimeLoaded = false;break;
                    case SLOT_CREATE_BY:
                    		__modified().__createByLoaded = false;break;
                    case SLOT_UPDATE_BY:
                    		__modified().__updateByLoaded = false;break;
                    case SLOT_REMARK:
                    		__modified().__remarkLoaded = false;break;
                    case SLOT_USER_ID:
                    		__modified().__userIdLoaded = false;break;
                    case SLOT_USERNAME:
                    		__modified().__usernameValue = null;break;
                    case SLOT_PASSWORD:
                    		__modified().__passwordValue = null;break;
                    case SLOT_NICK_NAME:
                    		__modified().__nickNameValue = null;break;
                    case SLOT_PHONE:
                    		__modified().__phoneLoaded = false;break;
                    case SLOT_EMAIL:
                    		__modified().__emailLoaded = false;break;
                    case SLOT_AVATAR:
                    		__modified().__avatarLoaded = false;break;
                    case SLOT_LAST_LOGIN_TIME:
                    		__modified().__lastLoginTimeLoaded = false;break;
                    case SLOT_STATUS:
                    		__modified().__statusLoaded = false;break;
                    case SLOT_USER_DETAIL_ID:
                    		__unload(PropId.byIndex(SLOT_USER_DETAIL));break;
                    case SLOT_USER_DETAIL:
                    		__modified().__userDetailLoaded = false;break;
                    case SLOT_DEPT_LIST:
                    		__modified().__deptListValue = null;break;
                    default: throw new IllegalArgumentException("Illegal property id for \"com.leaf.domain.LeafUser\": \"" + prop + "\", it does not exist or its loaded state is not controllable");
                }
            }

            @Override
            public void __unload(String prop) {
                switch (prop) {
                    case "createTime":
                    		__modified().__createTimeLoaded = false;break;
                    case "updateTime":
                    		__modified().__updateTimeLoaded = false;break;
                    case "createBy":
                    		__modified().__createByLoaded = false;break;
                    case "updateBy":
                    		__modified().__updateByLoaded = false;break;
                    case "remark":
                    		__modified().__remarkLoaded = false;break;
                    case "userId":
                    		__modified().__userIdLoaded = false;break;
                    case "username":
                    		__modified().__usernameValue = null;break;
                    case "password":
                    		__modified().__passwordValue = null;break;
                    case "nickName":
                    		__modified().__nickNameValue = null;break;
                    case "phone":
                    		__modified().__phoneLoaded = false;break;
                    case "email":
                    		__modified().__emailLoaded = false;break;
                    case "avatar":
                    		__modified().__avatarLoaded = false;break;
                    case "lastLoginTime":
                    		__modified().__lastLoginTimeLoaded = false;break;
                    case "status":
                    		__modified().__statusLoaded = false;break;
                    case "userDetailId":
                    		__unload(PropId.byIndex(SLOT_USER_DETAIL));break;
                    case "userDetail":
                    		__modified().__userDetailLoaded = false;break;
                    case "deptList":
                    		__modified().__deptListValue = null;break;
                    default: throw new IllegalArgumentException("Illegal property name for \"com.leaf.domain.LeafUser\": \"" + prop + "\", it does not exist or its loaded state is not controllable");
                }
            }

            @Override
            public DraftContext __draftContext() {
                return __ctx;
            }

            @Override
            public Object __resolve() {
                if (__resolving) {
                    throw new CircularReferenceException();
                }
                __resolving = true;
                try {
                    Implementor base = __base;
                    Impl __tmpModified = __modified;
                    if (__tmpModified == null) {
                        if (base.__isLoaded(PropId.byIndex(SLOT_USER_DETAIL))) {
                            LeafUserDetail oldValue = base.userDetail();
                            LeafUserDetail newValue = __ctx.resolveObject(oldValue);
                            if (oldValue != newValue) {
                                setUserDetail(newValue);
                            }
                        }
                        if (base.__isLoaded(PropId.byIndex(SLOT_DEPT_LIST))) {
                            List<LeafDept> oldValue = base.deptList();
                            List<LeafDept> newValue = __ctx.resolveList(oldValue);
                            if (oldValue != newValue) {
                                setDeptList(newValue);
                            }
                        }
                        __tmpModified = __modified;
                    }
                    else {
                        __tmpModified.__userDetailValue = __ctx.resolveObject(__tmpModified.__userDetailValue);
                        __tmpModified.__deptListValue = NonSharedList.of(__tmpModified.__deptListValue, __ctx.resolveList(__tmpModified.__deptListValue));
                    }
                    if (__base != null && __tmpModified == null) {
                        return base;
                    }
                    return __tmpModified;
                }
                finally {
                    __resolving = false;
                }
            }

            Impl __modified() {
                Impl __tmpModified = __modified;
                if (__tmpModified == null) {
                    __tmpModified = __base.clone();
                    __modified = __tmpModified;
                }
                return __tmpModified;
            }
        }
    }

    class Builder {
        private final Producer.DraftImpl __draft;

        public Builder() {
            __draft = new Producer.DraftImpl(null, null);
            __draft.__show(PropId.byIndex(Producer.SLOT_USER_DETAIL_ID), false);
            __draft.__show(PropId.byIndex(Producer.SLOT_USER_DETAIL), false);
        }

        public Builder userId(Long userId) {
            if (userId != null) {
                __draft.setUserId(userId);
            }
            return this;
        }

        @Nullable
        public Builder createTime(LocalDateTime createTime) {
            __draft.setCreateTime(createTime);
            return this;
        }

        @Nullable
        public Builder updateTime(LocalDateTime updateTime) {
            __draft.setUpdateTime(updateTime);
            return this;
        }

        @Nullable
        public Builder createBy(String createBy) {
            __draft.setCreateBy(createBy);
            return this;
        }

        @Nullable
        public Builder updateBy(String updateBy) {
            __draft.setUpdateBy(updateBy);
            return this;
        }

        @Nullable
        public Builder remark(String remark) {
            __draft.setRemark(remark);
            return this;
        }

        public Builder username(String username) {
            if (username != null) {
                __draft.setUsername(username);
            }
            return this;
        }

        public Builder password(String password) {
            if (password != null) {
                __draft.setPassword(password);
            }
            return this;
        }

        public Builder nickName(String nickName) {
            if (nickName != null) {
                __draft.setNickName(nickName);
            }
            return this;
        }

        @Nullable
        public Builder phone(String phone) {
            __draft.setPhone(phone);
            return this;
        }

        @Nullable
        public Builder email(String email) {
            __draft.setEmail(email);
            return this;
        }

        @Nullable
        public Builder avatar(String avatar) {
            __draft.setAvatar(avatar);
            return this;
        }

        @Nullable
        public Builder lastLoginTime(LocalDate lastLoginTime) {
            __draft.setLastLoginTime(lastLoginTime);
            return this;
        }

        public Builder status(Integer status) {
            if (status != null) {
                __draft.setStatus(status);
            }
            return this;
        }

        public Builder userDetailId(Long userDetailId) {
            __draft.setUserDetailId(userDetailId);
            __draft.__show(PropId.byIndex(Producer.SLOT_USER_DETAIL_ID), true);
            return this;
        }

        @Nullable
        public Builder userDetail(LeafUserDetail userDetail) {
            __draft.setUserDetail(userDetail);
            __draft.__show(PropId.byIndex(Producer.SLOT_USER_DETAIL), true);
            return this;
        }

        public Builder deptList(List<LeafDept> deptList) {
            if (deptList != null) {
                __draft.setDeptList(deptList);
            }
            return this;
        }

        public LeafUser build() {
            return (LeafUser)__draft.__modified();
        }
    }
}
