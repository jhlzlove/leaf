package com.leaf.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import java.time.LocalDateTime;
import java.util.Collections;
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
import org.babyfish.jimmer.runtime.Visibility;
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

    @Nullable
    LeafUserDraft createBy();

    LeafUserDraft createBy(boolean autoCreate);

    @OldChain
    LeafUserDraft setCreateBy(LeafUser createBy);

    @Nullable
    Long createById();

    @OldChain
    LeafUserDraft setCreateById(@Nullable Long createById);

    @OldChain
    LeafUserDraft applyCreateBy(DraftConsumer<LeafUserDraft> block);

    @OldChain
    LeafUserDraft applyCreateBy(LeafUser base, DraftConsumer<LeafUserDraft> block);

    @Nullable
    LeafUserDraft updateBy();

    LeafUserDraft updateBy(boolean autoCreate);

    @OldChain
    LeafUserDraft setUpdateBy(LeafUser updateBy);

    @Nullable
    Long updateById();

    @OldChain
    LeafUserDraft setUpdateById(@Nullable Long updateById);

    @OldChain
    LeafUserDraft applyUpdateBy(DraftConsumer<LeafUserDraft> block);

    @OldChain
    LeafUserDraft applyUpdateBy(LeafUser base, DraftConsumer<LeafUserDraft> block);

    @OldChain
    LeafUserDraft setRemark(String remark);

    @OldChain
    LeafUserDraft setUsername(String username);

    @OldChain
    LeafUserDraft setPassword(String password);

    @OldChain
    LeafUserDraft setNickName(String nickName);

    @OldChain
    LeafUserDraft setAvatar(String avatar);

    @OldChain
    LeafUserDraft setStatus(Integer status);

    @OldChain
    LeafUserDraft setDelFlag(Integer delFlag);

    @OldChain
    LeafUserDraft setUserCode(String userCode);

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

        public static final int SLOT_AVATAR = 9;

        public static final int SLOT_STATUS = 10;

        public static final int SLOT_DEL_FLAG = 11;

        public static final int SLOT_USER_CODE = 12;

        public static final ImmutableType TYPE = ImmutableType
            .newBuilder(
                "0.8.109",
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
            .add(SLOT_AVATAR, "avatar", ImmutablePropCategory.SCALAR, String.class, false)
            .add(SLOT_STATUS, "status", ImmutablePropCategory.SCALAR, Integer.class, true)
            .add(SLOT_DEL_FLAG, "delFlag", ImmutablePropCategory.SCALAR, Integer.class, true)
            .add(SLOT_USER_CODE, "userCode", ImmutablePropCategory.SCALAR, String.class, false)
            .build();

        private Producer() {
        }

        public LeafUser produce(DraftConsumer<LeafUserDraft> block) {
            return produce(null, block);
        }

        public LeafUser produce(LeafUser base, DraftConsumer<LeafUserDraft> block) {
            return (LeafUser)Internal.produce(TYPE, base, block);
        }

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
                    case SLOT_AVATAR:
                    		return avatar();
                    case SLOT_STATUS:
                    		return status();
                    case SLOT_DEL_FLAG:
                    		return delFlag();
                    case SLOT_USER_CODE:
                    		return userCode();
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
                    case "avatar":
                    		return avatar();
                    case "status":
                    		return status();
                    case "delFlag":
                    		return delFlag();
                    case "userCode":
                    		return userCode();
                    default: throw new IllegalArgumentException("Illegal property name for \"com.leaf.domain.LeafUser\": \"" + prop + "\"");
                }
            }

            @JsonIgnore
            default long getUserId() {
                return userId();
            }

            @JsonIgnore
            default LocalDateTime getCreateTime() {
                return createTime();
            }

            @JsonIgnore
            default LocalDateTime getUpdateTime() {
                return updateTime();
            }

            @JsonIgnore
            default LeafUser getCreateBy() {
                return createBy();
            }

            @JsonIgnore
            default LeafUser getUpdateBy() {
                return updateBy();
            }

            @JsonIgnore
            default String getRemark() {
                return remark();
            }

            @JsonIgnore
            default String getUsername() {
                return username();
            }

            @JsonIgnore
            default String getPassword() {
                return password();
            }

            @JsonIgnore
            default String getNickName() {
                return nickName();
            }

            @JsonIgnore
            default String getAvatar() {
                return avatar();
            }

            @JsonIgnore
            default Integer getStatus() {
                return status();
            }

            @JsonIgnore
            default Integer getDelFlag() {
                return delFlag();
            }

            @JsonIgnore
            default String getUserCode() {
                return userCode();
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

            LocalDateTime __updateTimeValue;

            LeafUser __createByValue;

            boolean __createByLoaded = false;

            LeafUser __updateByValue;

            boolean __updateByLoaded = false;

            String __remarkValue;

            String __usernameValue;

            String __passwordValue;

            String __nickNameValue;

            String __avatarValue;

            Integer __statusValue;

            boolean __statusLoaded = false;

            Integer __delFlagValue;

            boolean __delFlagLoaded = false;

            String __userCodeValue;

            @Override
            public long userId() {
                if (!__userIdLoaded) {
                    throw new UnloadedException(LeafUser.class, "userId");
                }
                return __userIdValue;
            }

            @Override
            public LocalDateTime createTime() {
                if (__createTimeValue == null) {
                    throw new UnloadedException(LeafUser.class, "createTime");
                }
                return __createTimeValue;
            }

            @Override
            public LocalDateTime updateTime() {
                if (__updateTimeValue == null) {
                    throw new UnloadedException(LeafUser.class, "updateTime");
                }
                return __updateTimeValue;
            }

            @Override
            @Nullable
            public LeafUser createBy() {
                if (!__createByLoaded) {
                    throw new UnloadedException(LeafUser.class, "createBy");
                }
                return __createByValue;
            }

            @Override
            @Nullable
            public LeafUser updateBy() {
                if (!__updateByLoaded) {
                    throw new UnloadedException(LeafUser.class, "updateBy");
                }
                return __updateByValue;
            }

            @Override
            public String remark() {
                if (__remarkValue == null) {
                    throw new UnloadedException(LeafUser.class, "remark");
                }
                return __remarkValue;
            }

            @Override
            public String username() {
                if (__usernameValue == null) {
                    throw new UnloadedException(LeafUser.class, "username");
                }
                return __usernameValue;
            }

            @Override
            public String password() {
                if (__passwordValue == null) {
                    throw new UnloadedException(LeafUser.class, "password");
                }
                return __passwordValue;
            }

            @Override
            public String nickName() {
                if (__nickNameValue == null) {
                    throw new UnloadedException(LeafUser.class, "nickName");
                }
                return __nickNameValue;
            }

            @Override
            public String avatar() {
                if (__avatarValue == null) {
                    throw new UnloadedException(LeafUser.class, "avatar");
                }
                return __avatarValue;
            }

            @Override
            @Nullable
            public Integer status() {
                if (!__statusLoaded) {
                    throw new UnloadedException(LeafUser.class, "status");
                }
                return __statusValue;
            }

            @Override
            @Nullable
            public Integer delFlag() {
                if (!__delFlagLoaded) {
                    throw new UnloadedException(LeafUser.class, "delFlag");
                }
                return __delFlagValue;
            }

            @Override
            public String userCode() {
                if (__userCodeValue == null) {
                    throw new UnloadedException(LeafUser.class, "userCode");
                }
                return __userCodeValue;
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
                    		return __createTimeValue != null;
                    case SLOT_UPDATE_TIME:
                    		return __updateTimeValue != null;
                    case SLOT_CREATE_BY:
                    		return __createByLoaded;
                    case SLOT_UPDATE_BY:
                    		return __updateByLoaded;
                    case SLOT_REMARK:
                    		return __remarkValue != null;
                    case SLOT_USER_ID:
                    		return __userIdLoaded;
                    case SLOT_USERNAME:
                    		return __usernameValue != null;
                    case SLOT_PASSWORD:
                    		return __passwordValue != null;
                    case SLOT_NICK_NAME:
                    		return __nickNameValue != null;
                    case SLOT_AVATAR:
                    		return __avatarValue != null;
                    case SLOT_STATUS:
                    		return __statusLoaded;
                    case SLOT_DEL_FLAG:
                    		return __delFlagLoaded;
                    case SLOT_USER_CODE:
                    		return __userCodeValue != null;
                    default: throw new IllegalArgumentException("Illegal property name for \"com.leaf.domain.LeafUser\": \"" + prop + "\"");
                }
            }

            @Override
            public boolean __isLoaded(String prop) {
                switch (prop) {
                    case "createTime":
                    		return __createTimeValue != null;
                    case "updateTime":
                    		return __updateTimeValue != null;
                    case "createBy":
                    		return __createByLoaded;
                    case "updateBy":
                    		return __updateByLoaded;
                    case "remark":
                    		return __remarkValue != null;
                    case "userId":
                    		return __userIdLoaded;
                    case "username":
                    		return __usernameValue != null;
                    case "password":
                    		return __passwordValue != null;
                    case "nickName":
                    		return __nickNameValue != null;
                    case "avatar":
                    		return __avatarValue != null;
                    case "status":
                    		return __statusLoaded;
                    case "delFlag":
                    		return __delFlagLoaded;
                    case "userCode":
                    		return __userCodeValue != null;
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
                    case SLOT_AVATAR:
                    		return __visibility.visible(SLOT_AVATAR);
                    case SLOT_STATUS:
                    		return __visibility.visible(SLOT_STATUS);
                    case SLOT_DEL_FLAG:
                    		return __visibility.visible(SLOT_DEL_FLAG);
                    case SLOT_USER_CODE:
                    		return __visibility.visible(SLOT_USER_CODE);
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
                    case "avatar":
                    		return __visibility.visible(SLOT_AVATAR);
                    case "status":
                    		return __visibility.visible(SLOT_STATUS);
                    case "delFlag":
                    		return __visibility.visible(SLOT_DEL_FLAG);
                    case "userCode":
                    		return __visibility.visible(SLOT_USER_CODE);
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
                if (__createTimeValue != null) {
                    hash = 31 * hash + __createTimeValue.hashCode();
                }
                if (__updateTimeValue != null) {
                    hash = 31 * hash + __updateTimeValue.hashCode();
                }
                if (__createByLoaded && __createByValue != null) {
                    hash = 31 * hash + __createByValue.hashCode();
                }
                if (__updateByLoaded && __updateByValue != null) {
                    hash = 31 * hash + __updateByValue.hashCode();
                }
                if (__remarkValue != null) {
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
                if (__avatarValue != null) {
                    hash = 31 * hash + __avatarValue.hashCode();
                }
                if (__statusLoaded && __statusValue != null) {
                    hash = 31 * hash + __statusValue.hashCode();
                }
                if (__delFlagLoaded && __delFlagValue != null) {
                    hash = 31 * hash + __delFlagValue.hashCode();
                }
                if (__userCodeValue != null) {
                    hash = 31 * hash + __userCodeValue.hashCode();
                }
                return hash;
            }

            private int __shallowHashCode() {
                int hash = __visibility != null ? __visibility.hashCode() : 0;
                if (__userIdLoaded) {
                    hash = 31 * hash + Long.hashCode(__userIdValue);
                }
                if (__createTimeValue != null) {
                    hash = 31 * hash + System.identityHashCode(__createTimeValue);
                }
                if (__updateTimeValue != null) {
                    hash = 31 * hash + System.identityHashCode(__updateTimeValue);
                }
                if (__createByLoaded) {
                    hash = 31 * hash + System.identityHashCode(__createByValue);
                }
                if (__updateByLoaded) {
                    hash = 31 * hash + System.identityHashCode(__updateByValue);
                }
                if (__remarkValue != null) {
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
                if (__avatarValue != null) {
                    hash = 31 * hash + System.identityHashCode(__avatarValue);
                }
                if (__statusLoaded) {
                    hash = 31 * hash + System.identityHashCode(__statusValue);
                }
                if (__delFlagLoaded) {
                    hash = 31 * hash + System.identityHashCode(__delFlagValue);
                }
                if (__userCodeValue != null) {
                    hash = 31 * hash + System.identityHashCode(__userCodeValue);
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
                boolean __createTimeLoaded = __createTimeValue != null;
                if (__createTimeLoaded != __other.__isLoaded(PropId.byIndex(SLOT_CREATE_TIME))) {
                    return false;
                }
                if (__createTimeLoaded && !Objects.equals(__createTimeValue, __other.createTime())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_UPDATE_TIME)) != __other.__isVisible(PropId.byIndex(SLOT_UPDATE_TIME))) {
                    return false;
                }
                boolean __updateTimeLoaded = __updateTimeValue != null;
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
                boolean __remarkLoaded = __remarkValue != null;
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
                if (__isVisible(PropId.byIndex(SLOT_AVATAR)) != __other.__isVisible(PropId.byIndex(SLOT_AVATAR))) {
                    return false;
                }
                boolean __avatarLoaded = __avatarValue != null;
                if (__avatarLoaded != __other.__isLoaded(PropId.byIndex(SLOT_AVATAR))) {
                    return false;
                }
                if (__avatarLoaded && !Objects.equals(__avatarValue, __other.avatar())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_STATUS)) != __other.__isVisible(PropId.byIndex(SLOT_STATUS))) {
                    return false;
                }
                boolean __statusLoaded = this.__statusLoaded;
                if (__statusLoaded != __other.__isLoaded(PropId.byIndex(SLOT_STATUS))) {
                    return false;
                }
                if (__statusLoaded && !Objects.equals(__statusValue, __other.status())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_DEL_FLAG)) != __other.__isVisible(PropId.byIndex(SLOT_DEL_FLAG))) {
                    return false;
                }
                boolean __delFlagLoaded = this.__delFlagLoaded;
                if (__delFlagLoaded != __other.__isLoaded(PropId.byIndex(SLOT_DEL_FLAG))) {
                    return false;
                }
                if (__delFlagLoaded && !Objects.equals(__delFlagValue, __other.delFlag())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_USER_CODE)) != __other.__isVisible(PropId.byIndex(SLOT_USER_CODE))) {
                    return false;
                }
                boolean __userCodeLoaded = __userCodeValue != null;
                if (__userCodeLoaded != __other.__isLoaded(PropId.byIndex(SLOT_USER_CODE))) {
                    return false;
                }
                if (__userCodeLoaded && !Objects.equals(__userCodeValue, __other.userCode())) {
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
                boolean __createTimeLoaded = __createTimeValue != null;
                if (__createTimeLoaded != __other.__isLoaded(PropId.byIndex(SLOT_CREATE_TIME))) {
                    return false;
                }
                if (__createTimeLoaded && __createTimeValue != __other.createTime()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_UPDATE_TIME)) != __other.__isVisible(PropId.byIndex(SLOT_UPDATE_TIME))) {
                    return false;
                }
                boolean __updateTimeLoaded = __updateTimeValue != null;
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
                boolean __remarkLoaded = __remarkValue != null;
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
                if (__isVisible(PropId.byIndex(SLOT_AVATAR)) != __other.__isVisible(PropId.byIndex(SLOT_AVATAR))) {
                    return false;
                }
                boolean __avatarLoaded = __avatarValue != null;
                if (__avatarLoaded != __other.__isLoaded(PropId.byIndex(SLOT_AVATAR))) {
                    return false;
                }
                if (__avatarLoaded && __avatarValue != __other.avatar()) {
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
                if (__isVisible(PropId.byIndex(SLOT_DEL_FLAG)) != __other.__isVisible(PropId.byIndex(SLOT_DEL_FLAG))) {
                    return false;
                }
                boolean __delFlagLoaded = this.__delFlagLoaded;
                if (__delFlagLoaded != __other.__isLoaded(PropId.byIndex(SLOT_DEL_FLAG))) {
                    return false;
                }
                if (__delFlagLoaded && __delFlagValue != __other.delFlag()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_USER_CODE)) != __other.__isVisible(PropId.byIndex(SLOT_USER_CODE))) {
                    return false;
                }
                boolean __userCodeLoaded = __userCodeValue != null;
                if (__userCodeLoaded != __other.__isLoaded(PropId.byIndex(SLOT_USER_CODE))) {
                    return false;
                }
                if (__userCodeLoaded && __userCodeValue != __other.userCode()) {
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
            public LocalDateTime createTime() {
                return (__modified!= null ? __modified : __base).createTime();
            }

            @Override
            public LeafUserDraft setCreateTime(LocalDateTime createTime) {
                if (createTime == null) {
                    throw new IllegalArgumentException(
                        "'createTime' cannot be null, please specify non-null value or use nullable annotation to decorate this property"
                    );
                }
                Impl __tmpModified = __modified();
                __tmpModified.__createTimeValue = createTime;
                return this;
            }

            @Override
            public LocalDateTime updateTime() {
                return (__modified!= null ? __modified : __base).updateTime();
            }

            @Override
            public LeafUserDraft setUpdateTime(LocalDateTime updateTime) {
                if (updateTime == null) {
                    throw new IllegalArgumentException(
                        "'updateTime' cannot be null, please specify non-null value or use nullable annotation to decorate this property"
                    );
                }
                Impl __tmpModified = __modified();
                __tmpModified.__updateTimeValue = updateTime;
                return this;
            }

            @Override
            @Nullable
            public LeafUserDraft createBy() {
                return __ctx.toDraftObject((__modified!= null ? __modified : __base).createBy());
            }

            @Override
            public LeafUserDraft createBy(boolean autoCreate) {
                if (autoCreate && (!__isLoaded(PropId.byIndex(SLOT_CREATE_BY)) || createBy() == null)) {
                    setCreateBy(LeafUserDraft.$.produce(null, null));
                }
                return __ctx.toDraftObject((__modified!= null ? __modified : __base).createBy());
            }

            @Override
            public LeafUserDraft setCreateBy(LeafUser createBy) {
                Impl __tmpModified = __modified();
                __tmpModified.__createByValue = createBy;
                __tmpModified.__createByLoaded = true;
                return this;
            }

            @Nullable
            @Override
            public Long createById() {
                LeafUser createBy = createBy();
                if (createBy == null) {
                    return null;
                }
                return createBy.userId();
            }

            @OldChain
            @Override
            public LeafUserDraft setCreateById(@Nullable Long createById) {
                if (createById == null) {
                    setCreateBy(null);
                    return this;
                }
                createBy(true).setUserId(createById);
                return this;
            }

            @Override
            public LeafUserDraft applyCreateBy(DraftConsumer<LeafUserDraft> block) {
                applyCreateBy(null, block);
                return this;
            }

            @Override
            public LeafUserDraft applyCreateBy(LeafUser base, DraftConsumer<LeafUserDraft> block) {
                setCreateBy(LeafUserDraft.$.produce(base, block));
                return this;
            }

            @Override
            @Nullable
            public LeafUserDraft updateBy() {
                return __ctx.toDraftObject((__modified!= null ? __modified : __base).updateBy());
            }

            @Override
            public LeafUserDraft updateBy(boolean autoCreate) {
                if (autoCreate && (!__isLoaded(PropId.byIndex(SLOT_UPDATE_BY)) || updateBy() == null)) {
                    setUpdateBy(LeafUserDraft.$.produce(null, null));
                }
                return __ctx.toDraftObject((__modified!= null ? __modified : __base).updateBy());
            }

            @Override
            public LeafUserDraft setUpdateBy(LeafUser updateBy) {
                Impl __tmpModified = __modified();
                __tmpModified.__updateByValue = updateBy;
                __tmpModified.__updateByLoaded = true;
                return this;
            }

            @Nullable
            @Override
            public Long updateById() {
                LeafUser updateBy = updateBy();
                if (updateBy == null) {
                    return null;
                }
                return updateBy.userId();
            }

            @OldChain
            @Override
            public LeafUserDraft setUpdateById(@Nullable Long updateById) {
                if (updateById == null) {
                    setUpdateBy(null);
                    return this;
                }
                updateBy(true).setUserId(updateById);
                return this;
            }

            @Override
            public LeafUserDraft applyUpdateBy(DraftConsumer<LeafUserDraft> block) {
                applyUpdateBy(null, block);
                return this;
            }

            @Override
            public LeafUserDraft applyUpdateBy(LeafUser base, DraftConsumer<LeafUserDraft> block) {
                setUpdateBy(LeafUserDraft.$.produce(base, block));
                return this;
            }

            @Override
            public String remark() {
                return (__modified!= null ? __modified : __base).remark();
            }

            @Override
            public LeafUserDraft setRemark(String remark) {
                if (remark == null) {
                    throw new IllegalArgumentException(
                        "'remark' cannot be null, please specify non-null value or use nullable annotation to decorate this property"
                    );
                }
                Impl __tmpModified = __modified();
                __tmpModified.__remarkValue = remark;
                return this;
            }

            @Override
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
            public String avatar() {
                return (__modified!= null ? __modified : __base).avatar();
            }

            @Override
            public LeafUserDraft setAvatar(String avatar) {
                if (avatar == null) {
                    throw new IllegalArgumentException(
                        "'avatar' cannot be null, please specify non-null value or use nullable annotation to decorate this property"
                    );
                }
                Impl __tmpModified = __modified();
                __tmpModified.__avatarValue = avatar;
                return this;
            }

            @Override
            @Nullable
            public Integer status() {
                return (__modified!= null ? __modified : __base).status();
            }

            @Override
            public LeafUserDraft setStatus(Integer status) {
                Impl __tmpModified = __modified();
                __tmpModified.__statusValue = status;
                __tmpModified.__statusLoaded = true;
                return this;
            }

            @Override
            @Nullable
            public Integer delFlag() {
                return (__modified!= null ? __modified : __base).delFlag();
            }

            @Override
            public LeafUserDraft setDelFlag(Integer delFlag) {
                Impl __tmpModified = __modified();
                __tmpModified.__delFlagValue = delFlag;
                __tmpModified.__delFlagLoaded = true;
                return this;
            }

            @Override
            public String userCode() {
                return (__modified!= null ? __modified : __base).userCode();
            }

            @Override
            public LeafUserDraft setUserCode(String userCode) {
                if (userCode == null) {
                    throw new IllegalArgumentException(
                        "'userCode' cannot be null, please specify non-null value or use nullable annotation to decorate this property"
                    );
                }
                Impl __tmpModified = __modified();
                __tmpModified.__userCodeValue = userCode;
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
                    		setCreateBy((LeafUser)value);break;
                    case SLOT_UPDATE_BY:
                    		setUpdateBy((LeafUser)value);break;
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
                    case SLOT_AVATAR:
                    		setAvatar((String)value);break;
                    case SLOT_STATUS:
                    		setStatus((Integer)value);break;
                    case SLOT_DEL_FLAG:
                    		setDelFlag((Integer)value);break;
                    case SLOT_USER_CODE:
                    		setUserCode((String)value);break;
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
                    		setCreateBy((LeafUser)value);break;
                    case "updateBy":
                    		setUpdateBy((LeafUser)value);break;
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
                    case "avatar":
                    		setAvatar((String)value);break;
                    case "status":
                    		setStatus((Integer)value);break;
                    case "delFlag":
                    		setDelFlag((Integer)value);break;
                    case "userCode":
                    		setUserCode((String)value);break;
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
                    __modified().__visibility = __visibility = Visibility.of(13);
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
                    case SLOT_AVATAR:
                    		__visibility.show(SLOT_AVATAR, visible);break;
                    case SLOT_STATUS:
                    		__visibility.show(SLOT_STATUS, visible);break;
                    case SLOT_DEL_FLAG:
                    		__visibility.show(SLOT_DEL_FLAG, visible);break;
                    case SLOT_USER_CODE:
                    		__visibility.show(SLOT_USER_CODE, visible);break;
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
                    __modified().__visibility = __visibility = Visibility.of(13);
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
                    case "avatar":
                    		__visibility.show(SLOT_AVATAR, visible);break;
                    case "status":
                    		__visibility.show(SLOT_STATUS, visible);break;
                    case "delFlag":
                    		__visibility.show(SLOT_DEL_FLAG, visible);break;
                    case "userCode":
                    		__visibility.show(SLOT_USER_CODE, visible);break;
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
                    		__modified().__createTimeValue = null;break;
                    case SLOT_UPDATE_TIME:
                    		__modified().__updateTimeValue = null;break;
                    case SLOT_CREATE_BY:
                    		__modified().__createByLoaded = false;break;
                    case SLOT_UPDATE_BY:
                    		__modified().__updateByLoaded = false;break;
                    case SLOT_REMARK:
                    		__modified().__remarkValue = null;break;
                    case SLOT_USER_ID:
                    		__modified().__userIdLoaded = false;break;
                    case SLOT_USERNAME:
                    		__modified().__usernameValue = null;break;
                    case SLOT_PASSWORD:
                    		__modified().__passwordValue = null;break;
                    case SLOT_NICK_NAME:
                    		__modified().__nickNameValue = null;break;
                    case SLOT_AVATAR:
                    		__modified().__avatarValue = null;break;
                    case SLOT_STATUS:
                    		__modified().__statusLoaded = false;break;
                    case SLOT_DEL_FLAG:
                    		__modified().__delFlagLoaded = false;break;
                    case SLOT_USER_CODE:
                    		__modified().__userCodeValue = null;break;
                    default: throw new IllegalArgumentException("Illegal property id for \"com.leaf.domain.LeafUser\": \"" + prop + "\", it does not exist or its loaded state is not controllable");
                }
            }

            @Override
            public void __unload(String prop) {
                switch (prop) {
                    case "createTime":
                    		__modified().__createTimeValue = null;break;
                    case "updateTime":
                    		__modified().__updateTimeValue = null;break;
                    case "createBy":
                    		__modified().__createByLoaded = false;break;
                    case "updateBy":
                    		__modified().__updateByLoaded = false;break;
                    case "remark":
                    		__modified().__remarkValue = null;break;
                    case "userId":
                    		__modified().__userIdLoaded = false;break;
                    case "username":
                    		__modified().__usernameValue = null;break;
                    case "password":
                    		__modified().__passwordValue = null;break;
                    case "nickName":
                    		__modified().__nickNameValue = null;break;
                    case "avatar":
                    		__modified().__avatarValue = null;break;
                    case "status":
                    		__modified().__statusLoaded = false;break;
                    case "delFlag":
                    		__modified().__delFlagLoaded = false;break;
                    case "userCode":
                    		__modified().__userCodeValue = null;break;
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
                        if (base.__isLoaded(PropId.byIndex(SLOT_CREATE_BY))) {
                            LeafUser oldValue = base.createBy();
                            LeafUser newValue = __ctx.resolveObject(oldValue);
                            if (oldValue != newValue) {
                                setCreateBy(newValue);
                            }
                        }
                        if (base.__isLoaded(PropId.byIndex(SLOT_UPDATE_BY))) {
                            LeafUser oldValue = base.updateBy();
                            LeafUser newValue = __ctx.resolveObject(oldValue);
                            if (oldValue != newValue) {
                                setUpdateBy(newValue);
                            }
                        }
                        __tmpModified = __modified;
                    }
                    else {
                        __tmpModified.__createByValue = __ctx.resolveObject(__tmpModified.__createByValue);
                        __tmpModified.__updateByValue = __ctx.resolveObject(__tmpModified.__updateByValue);
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

            private Impl __modified() {
                Impl __tmpModified = __modified;
                if (__tmpModified == null) {
                    __tmpModified = __base.clone();
                    __modified = __tmpModified;
                }
                return __tmpModified;
            }
        }
    }

    class MapStruct {
        private Long userId;

        private LocalDateTime createTime;

        private LocalDateTime updateTime;

        private boolean __createByLoaded;

        private LeafUser createBy;

        private boolean __updateByLoaded;

        private LeafUser updateBy;

        private String remark;

        private String username;

        private String password;

        private String nickName;

        private String avatar;

        private boolean __statusLoaded;

        private Integer status;

        private boolean __delFlagLoaded;

        private Integer delFlag;

        private String userCode;

        public MapStruct userId(Long userId) {
            this.userId = userId;
            return this;
        }

        public MapStruct createTime(LocalDateTime createTime) {
            this.createTime = createTime;
            return this;
        }

        public MapStruct updateTime(LocalDateTime updateTime) {
            this.updateTime = updateTime;
            return this;
        }

        public MapStruct createBy(LeafUser createBy) {
            this.__createByLoaded = true;
            this.createBy = createBy;
            return this;
        }

        public MapStruct updateBy(LeafUser updateBy) {
            this.__updateByLoaded = true;
            this.updateBy = updateBy;
            return this;
        }

        public MapStruct remark(String remark) {
            this.remark = remark;
            return this;
        }

        public MapStruct username(String username) {
            this.username = username;
            return this;
        }

        public MapStruct password(String password) {
            this.password = password;
            return this;
        }

        public MapStruct nickName(String nickName) {
            this.nickName = nickName;
            return this;
        }

        public MapStruct avatar(String avatar) {
            this.avatar = avatar;
            return this;
        }

        public MapStruct status(Integer status) {
            this.__statusLoaded = true;
            this.status = status;
            return this;
        }

        public MapStruct delFlag(Integer delFlag) {
            this.__delFlagLoaded = true;
            this.delFlag = delFlag;
            return this;
        }

        public MapStruct userCode(String userCode) {
            this.userCode = userCode;
            return this;
        }

        public LeafUser build() {
            return LeafUserDraft.$.produce(__draft -> {
                if (userId != null) {
                    __draft.setUserId(userId);
                }
                if (createTime != null) {
                    __draft.setCreateTime(createTime);
                }
                if (updateTime != null) {
                    __draft.setUpdateTime(updateTime);
                }
                if (__createByLoaded) {
                    __draft.setCreateBy(createBy);
                }
                if (__updateByLoaded) {
                    __draft.setUpdateBy(updateBy);
                }
                if (remark != null) {
                    __draft.setRemark(remark);
                }
                if (username != null) {
                    __draft.setUsername(username);
                }
                if (password != null) {
                    __draft.setPassword(password);
                }
                if (nickName != null) {
                    __draft.setNickName(nickName);
                }
                if (avatar != null) {
                    __draft.setAvatar(avatar);
                }
                if (__statusLoaded) {
                    __draft.setStatus(status);
                }
                if (__delFlagLoaded) {
                    __draft.setDelFlag(delFlag);
                }
                if (userCode != null) {
                    __draft.setUserCode(userCode);
                }
            });
        }
    }
}
