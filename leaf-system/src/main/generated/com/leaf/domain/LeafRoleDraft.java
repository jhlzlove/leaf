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
        type = LeafRole.class
)
public interface LeafRoleDraft extends LeafRole, BaseEntityDraft {
    LeafRoleDraft.Producer $ = Producer.INSTANCE;

    @OldChain
    LeafRoleDraft setRoleId(long roleId);

    @OldChain
    LeafRoleDraft setCreateTime(LocalDateTime createTime);

    @OldChain
    LeafRoleDraft setUpdateTime(LocalDateTime updateTime);

    @Nullable
    LeafUserDraft createBy();

    LeafUserDraft createBy(boolean autoCreate);

    @OldChain
    LeafRoleDraft setCreateBy(LeafUser createBy);

    @Nullable
    Long createById();

    @OldChain
    LeafRoleDraft setCreateById(@Nullable Long createById);

    @OldChain
    LeafRoleDraft applyCreateBy(DraftConsumer<LeafUserDraft> block);

    @OldChain
    LeafRoleDraft applyCreateBy(LeafUser base, DraftConsumer<LeafUserDraft> block);

    @Nullable
    LeafUserDraft updateBy();

    LeafUserDraft updateBy(boolean autoCreate);

    @OldChain
    LeafRoleDraft setUpdateBy(LeafUser updateBy);

    @Nullable
    Long updateById();

    @OldChain
    LeafRoleDraft setUpdateById(@Nullable Long updateById);

    @OldChain
    LeafRoleDraft applyUpdateBy(DraftConsumer<LeafUserDraft> block);

    @OldChain
    LeafRoleDraft applyUpdateBy(LeafUser base, DraftConsumer<LeafUserDraft> block);

    @OldChain
    LeafRoleDraft setRemark(String remark);

    @OldChain
    LeafRoleDraft setRoleCode(String roleCode);

    @OldChain
    LeafRoleDraft setPCode(String pCode);

    @OldChain
    LeafRoleDraft setRoleName(String roleName);

    @OldChain
    LeafRoleDraft setStatus(Integer status);

    class Producer {
        static final Producer INSTANCE = new Producer();

        public static final int SLOT_ROLE_ID = 5;

        public static final int SLOT_CREATE_TIME = 0;

        public static final int SLOT_UPDATE_TIME = 1;

        public static final int SLOT_CREATE_BY = 2;

        public static final int SLOT_UPDATE_BY = 3;

        public static final int SLOT_REMARK = 4;

        public static final int SLOT_ROLE_CODE = 6;

        public static final int SLOT_P_CODE = 7;

        public static final int SLOT_ROLE_NAME = 8;

        public static final int SLOT_STATUS = 9;

        public static final ImmutableType TYPE = ImmutableType
            .newBuilder(
                "0.8.109",
                LeafRole.class,
                Collections.singleton(BaseEntityDraft.Producer.TYPE),
                (ctx, base) -> new DraftImpl(ctx, (LeafRole)base)
            )
            .redefine("createTime", SLOT_CREATE_TIME)
            .redefine("updateTime", SLOT_UPDATE_TIME)
            .redefine("createBy", SLOT_CREATE_BY)
            .redefine("updateBy", SLOT_UPDATE_BY)
            .redefine("remark", SLOT_REMARK)
            .id(SLOT_ROLE_ID, "roleId", long.class)
            .add(SLOT_ROLE_CODE, "roleCode", ImmutablePropCategory.SCALAR, String.class, false)
            .add(SLOT_P_CODE, "pCode", ImmutablePropCategory.SCALAR, String.class, false)
            .add(SLOT_ROLE_NAME, "roleName", ImmutablePropCategory.SCALAR, String.class, false)
            .add(SLOT_STATUS, "status", ImmutablePropCategory.SCALAR, Integer.class, true)
            .build();

        private Producer() {
        }

        public LeafRole produce(DraftConsumer<LeafRoleDraft> block) {
            return produce(null, block);
        }

        public LeafRole produce(LeafRole base, DraftConsumer<LeafRoleDraft> block) {
            return (LeafRole)Internal.produce(TYPE, base, block);
        }

        public abstract interface Implementor extends LeafRole, ImmutableSpi {
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
                    case SLOT_ROLE_ID:
                    		return (Long)roleId();
                    case SLOT_ROLE_CODE:
                    		return roleCode();
                    case SLOT_P_CODE:
                    		return pCode();
                    case SLOT_ROLE_NAME:
                    		return roleName();
                    case SLOT_STATUS:
                    		return status();
                    default: throw new IllegalArgumentException("Illegal property name for \"com.leaf.domain.LeafRole\": \"" + prop + "\"");
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
                    case "roleId":
                    		return (Long)roleId();
                    case "roleCode":
                    		return roleCode();
                    case "pCode":
                    		return pCode();
                    case "roleName":
                    		return roleName();
                    case "status":
                    		return status();
                    default: throw new IllegalArgumentException("Illegal property name for \"com.leaf.domain.LeafRole\": \"" + prop + "\"");
                }
            }

            @JsonIgnore
            default long getRoleId() {
                return roleId();
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
            default String getRoleCode() {
                return roleCode();
            }

            @JsonIgnore
            default String getPCode() {
                return pCode();
            }

            @JsonIgnore
            default String getRoleName() {
                return roleName();
            }

            @JsonIgnore
            default Integer getStatus() {
                return status();
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

            long __roleIdValue;

            boolean __roleIdLoaded = false;

            LocalDateTime __createTimeValue;

            LocalDateTime __updateTimeValue;

            LeafUser __createByValue;

            boolean __createByLoaded = false;

            LeafUser __updateByValue;

            boolean __updateByLoaded = false;

            String __remarkValue;

            String __roleCodeValue;

            String __pCodeValue;

            String __roleNameValue;

            Integer __statusValue;

            boolean __statusLoaded = false;

            @Override
            public long roleId() {
                if (!__roleIdLoaded) {
                    throw new UnloadedException(LeafRole.class, "roleId");
                }
                return __roleIdValue;
            }

            @Override
            public LocalDateTime createTime() {
                if (__createTimeValue == null) {
                    throw new UnloadedException(LeafRole.class, "createTime");
                }
                return __createTimeValue;
            }

            @Override
            public LocalDateTime updateTime() {
                if (__updateTimeValue == null) {
                    throw new UnloadedException(LeafRole.class, "updateTime");
                }
                return __updateTimeValue;
            }

            @Override
            @Nullable
            public LeafUser createBy() {
                if (!__createByLoaded) {
                    throw new UnloadedException(LeafRole.class, "createBy");
                }
                return __createByValue;
            }

            @Override
            @Nullable
            public LeafUser updateBy() {
                if (!__updateByLoaded) {
                    throw new UnloadedException(LeafRole.class, "updateBy");
                }
                return __updateByValue;
            }

            @Override
            public String remark() {
                if (__remarkValue == null) {
                    throw new UnloadedException(LeafRole.class, "remark");
                }
                return __remarkValue;
            }

            @Override
            public String roleCode() {
                if (__roleCodeValue == null) {
                    throw new UnloadedException(LeafRole.class, "roleCode");
                }
                return __roleCodeValue;
            }

            @Override
            public String pCode() {
                if (__pCodeValue == null) {
                    throw new UnloadedException(LeafRole.class, "pCode");
                }
                return __pCodeValue;
            }

            @Override
            public String roleName() {
                if (__roleNameValue == null) {
                    throw new UnloadedException(LeafRole.class, "roleName");
                }
                return __roleNameValue;
            }

            @Override
            @Nullable
            public Integer status() {
                if (!__statusLoaded) {
                    throw new UnloadedException(LeafRole.class, "status");
                }
                return __statusValue;
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
                    case SLOT_ROLE_ID:
                    		return __roleIdLoaded;
                    case SLOT_ROLE_CODE:
                    		return __roleCodeValue != null;
                    case SLOT_P_CODE:
                    		return __pCodeValue != null;
                    case SLOT_ROLE_NAME:
                    		return __roleNameValue != null;
                    case SLOT_STATUS:
                    		return __statusLoaded;
                    default: throw new IllegalArgumentException("Illegal property name for \"com.leaf.domain.LeafRole\": \"" + prop + "\"");
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
                    case "roleId":
                    		return __roleIdLoaded;
                    case "roleCode":
                    		return __roleCodeValue != null;
                    case "pCode":
                    		return __pCodeValue != null;
                    case "roleName":
                    		return __roleNameValue != null;
                    case "status":
                    		return __statusLoaded;
                    default: throw new IllegalArgumentException("Illegal property name for \"com.leaf.domain.LeafRole\": \"" + prop + "\"");
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
                    case SLOT_ROLE_ID:
                    		return __visibility.visible(SLOT_ROLE_ID);
                    case SLOT_ROLE_CODE:
                    		return __visibility.visible(SLOT_ROLE_CODE);
                    case SLOT_P_CODE:
                    		return __visibility.visible(SLOT_P_CODE);
                    case SLOT_ROLE_NAME:
                    		return __visibility.visible(SLOT_ROLE_NAME);
                    case SLOT_STATUS:
                    		return __visibility.visible(SLOT_STATUS);
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
                    case "roleId":
                    		return __visibility.visible(SLOT_ROLE_ID);
                    case "roleCode":
                    		return __visibility.visible(SLOT_ROLE_CODE);
                    case "pCode":
                    		return __visibility.visible(SLOT_P_CODE);
                    case "roleName":
                    		return __visibility.visible(SLOT_ROLE_NAME);
                    case "status":
                    		return __visibility.visible(SLOT_STATUS);
                    default: return true;
                }
            }

            @Override
            public int hashCode() {
                int hash = __visibility != null ? __visibility.hashCode() : 0;
                if (__roleIdLoaded) {
                    hash = 31 * hash + Long.hashCode(__roleIdValue);
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
                if (__roleCodeValue != null) {
                    hash = 31 * hash + __roleCodeValue.hashCode();
                }
                if (__pCodeValue != null) {
                    hash = 31 * hash + __pCodeValue.hashCode();
                }
                if (__roleNameValue != null) {
                    hash = 31 * hash + __roleNameValue.hashCode();
                }
                if (__statusLoaded && __statusValue != null) {
                    hash = 31 * hash + __statusValue.hashCode();
                }
                return hash;
            }

            private int __shallowHashCode() {
                int hash = __visibility != null ? __visibility.hashCode() : 0;
                if (__roleIdLoaded) {
                    hash = 31 * hash + Long.hashCode(__roleIdValue);
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
                if (__roleCodeValue != null) {
                    hash = 31 * hash + System.identityHashCode(__roleCodeValue);
                }
                if (__pCodeValue != null) {
                    hash = 31 * hash + System.identityHashCode(__pCodeValue);
                }
                if (__roleNameValue != null) {
                    hash = 31 * hash + System.identityHashCode(__roleNameValue);
                }
                if (__statusLoaded) {
                    hash = 31 * hash + System.identityHashCode(__statusValue);
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
                if (__isVisible(PropId.byIndex(SLOT_ROLE_ID)) != __other.__isVisible(PropId.byIndex(SLOT_ROLE_ID))) {
                    return false;
                }
                boolean __roleIdLoaded = this.__roleIdLoaded;
                if (__roleIdLoaded != __other.__isLoaded(PropId.byIndex(SLOT_ROLE_ID))) {
                    return false;
                }
                if (__roleIdLoaded) {
                    // If entity-id is loaded, return directly
                    return __roleIdValue == __other.roleId();
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
                if (__isVisible(PropId.byIndex(SLOT_ROLE_CODE)) != __other.__isVisible(PropId.byIndex(SLOT_ROLE_CODE))) {
                    return false;
                }
                boolean __roleCodeLoaded = __roleCodeValue != null;
                if (__roleCodeLoaded != __other.__isLoaded(PropId.byIndex(SLOT_ROLE_CODE))) {
                    return false;
                }
                if (__roleCodeLoaded && !Objects.equals(__roleCodeValue, __other.roleCode())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_P_CODE)) != __other.__isVisible(PropId.byIndex(SLOT_P_CODE))) {
                    return false;
                }
                boolean __pCodeLoaded = __pCodeValue != null;
                if (__pCodeLoaded != __other.__isLoaded(PropId.byIndex(SLOT_P_CODE))) {
                    return false;
                }
                if (__pCodeLoaded && !Objects.equals(__pCodeValue, __other.pCode())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_ROLE_NAME)) != __other.__isVisible(PropId.byIndex(SLOT_ROLE_NAME))) {
                    return false;
                }
                boolean __roleNameLoaded = __roleNameValue != null;
                if (__roleNameLoaded != __other.__isLoaded(PropId.byIndex(SLOT_ROLE_NAME))) {
                    return false;
                }
                if (__roleNameLoaded && !Objects.equals(__roleNameValue, __other.roleName())) {
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
                return true;
            }

            private boolean __shallowEquals(Object obj) {
                if (obj == null || !(obj instanceof Implementor)) {
                    return false;
                }
                Implementor __other = (Implementor)obj;
                if (__isVisible(PropId.byIndex(SLOT_ROLE_ID)) != __other.__isVisible(PropId.byIndex(SLOT_ROLE_ID))) {
                    return false;
                }
                boolean __roleIdLoaded = this.__roleIdLoaded;
                if (__roleIdLoaded != __other.__isLoaded(PropId.byIndex(SLOT_ROLE_ID))) {
                    return false;
                }
                if (__roleIdLoaded && __roleIdValue != __other.roleId()) {
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
                if (__isVisible(PropId.byIndex(SLOT_ROLE_CODE)) != __other.__isVisible(PropId.byIndex(SLOT_ROLE_CODE))) {
                    return false;
                }
                boolean __roleCodeLoaded = __roleCodeValue != null;
                if (__roleCodeLoaded != __other.__isLoaded(PropId.byIndex(SLOT_ROLE_CODE))) {
                    return false;
                }
                if (__roleCodeLoaded && __roleCodeValue != __other.roleCode()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_P_CODE)) != __other.__isVisible(PropId.byIndex(SLOT_P_CODE))) {
                    return false;
                }
                boolean __pCodeLoaded = __pCodeValue != null;
                if (__pCodeLoaded != __other.__isLoaded(PropId.byIndex(SLOT_P_CODE))) {
                    return false;
                }
                if (__pCodeLoaded && __pCodeValue != __other.pCode()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_ROLE_NAME)) != __other.__isVisible(PropId.byIndex(SLOT_ROLE_NAME))) {
                    return false;
                }
                boolean __roleNameLoaded = __roleNameValue != null;
                if (__roleNameLoaded != __other.__isLoaded(PropId.byIndex(SLOT_ROLE_NAME))) {
                    return false;
                }
                if (__roleNameLoaded && __roleNameValue != __other.roleName()) {
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

        private static class DraftImpl implements Implementor, DraftSpi, LeafRoleDraft {
            private DraftContext __ctx;

            private Impl __base;

            private Impl __modified;

            private boolean __resolving;

            DraftImpl(DraftContext ctx, LeafRole base) {
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
            public long roleId() {
                return (__modified!= null ? __modified : __base).roleId();
            }

            @Override
            public LeafRoleDraft setRoleId(long roleId) {
                Impl __tmpModified = __modified();
                __tmpModified.__roleIdValue = roleId;
                __tmpModified.__roleIdLoaded = true;
                return this;
            }

            @Override
            public LocalDateTime createTime() {
                return (__modified!= null ? __modified : __base).createTime();
            }

            @Override
            public LeafRoleDraft setCreateTime(LocalDateTime createTime) {
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
            public LeafRoleDraft setUpdateTime(LocalDateTime updateTime) {
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
            public LeafRoleDraft setCreateBy(LeafUser createBy) {
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
            public LeafRoleDraft setCreateById(@Nullable Long createById) {
                if (createById == null) {
                    setCreateBy(null);
                    return this;
                }
                createBy(true).setUserId(createById);
                return this;
            }

            @Override
            public LeafRoleDraft applyCreateBy(DraftConsumer<LeafUserDraft> block) {
                applyCreateBy(null, block);
                return this;
            }

            @Override
            public LeafRoleDraft applyCreateBy(LeafUser base, DraftConsumer<LeafUserDraft> block) {
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
            public LeafRoleDraft setUpdateBy(LeafUser updateBy) {
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
            public LeafRoleDraft setUpdateById(@Nullable Long updateById) {
                if (updateById == null) {
                    setUpdateBy(null);
                    return this;
                }
                updateBy(true).setUserId(updateById);
                return this;
            }

            @Override
            public LeafRoleDraft applyUpdateBy(DraftConsumer<LeafUserDraft> block) {
                applyUpdateBy(null, block);
                return this;
            }

            @Override
            public LeafRoleDraft applyUpdateBy(LeafUser base, DraftConsumer<LeafUserDraft> block) {
                setUpdateBy(LeafUserDraft.$.produce(base, block));
                return this;
            }

            @Override
            public String remark() {
                return (__modified!= null ? __modified : __base).remark();
            }

            @Override
            public LeafRoleDraft setRemark(String remark) {
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
            public String roleCode() {
                return (__modified!= null ? __modified : __base).roleCode();
            }

            @Override
            public LeafRoleDraft setRoleCode(String roleCode) {
                if (roleCode == null) {
                    throw new IllegalArgumentException(
                        "'roleCode' cannot be null, please specify non-null value or use nullable annotation to decorate this property"
                    );
                }
                Impl __tmpModified = __modified();
                __tmpModified.__roleCodeValue = roleCode;
                return this;
            }

            @Override
            public String pCode() {
                return (__modified!= null ? __modified : __base).pCode();
            }

            @Override
            public LeafRoleDraft setPCode(String pCode) {
                if (pCode == null) {
                    throw new IllegalArgumentException(
                        "'pCode' cannot be null, please specify non-null value or use nullable annotation to decorate this property"
                    );
                }
                Impl __tmpModified = __modified();
                __tmpModified.__pCodeValue = pCode;
                return this;
            }

            @Override
            public String roleName() {
                return (__modified!= null ? __modified : __base).roleName();
            }

            @Override
            public LeafRoleDraft setRoleName(String roleName) {
                if (roleName == null) {
                    throw new IllegalArgumentException(
                        "'roleName' cannot be null, please specify non-null value or use nullable annotation to decorate this property"
                    );
                }
                Impl __tmpModified = __modified();
                __tmpModified.__roleNameValue = roleName;
                return this;
            }

            @Override
            @Nullable
            public Integer status() {
                return (__modified!= null ? __modified : __base).status();
            }

            @Override
            public LeafRoleDraft setStatus(Integer status) {
                Impl __tmpModified = __modified();
                __tmpModified.__statusValue = status;
                __tmpModified.__statusLoaded = true;
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
                    case SLOT_ROLE_ID:
                    		if (value == null) throw new IllegalArgumentException("'roleId' cannot be null, if you want to set null, please use any annotation whose simple name is \"Nullable\" to decorate the property");
                            setRoleId((Long)value);
                            break;
                    case SLOT_ROLE_CODE:
                    		setRoleCode((String)value);break;
                    case SLOT_P_CODE:
                    		setPCode((String)value);break;
                    case SLOT_ROLE_NAME:
                    		setRoleName((String)value);break;
                    case SLOT_STATUS:
                    		setStatus((Integer)value);break;
                    default: throw new IllegalArgumentException("Illegal property id for \"com.leaf.domain.LeafRole\": \"" + prop + "\"");
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
                    case "roleId":
                    		if (value == null) throw new IllegalArgumentException("'roleId' cannot be null, if you want to set null, please use any annotation whose simple name is \"Nullable\" to decorate the property");
                            setRoleId((Long)value);
                            break;
                    case "roleCode":
                    		setRoleCode((String)value);break;
                    case "pCode":
                    		setPCode((String)value);break;
                    case "roleName":
                    		setRoleName((String)value);break;
                    case "status":
                    		setStatus((Integer)value);break;
                    default: throw new IllegalArgumentException("Illegal property name for \"com.leaf.domain.LeafRole\": \"" + prop + "\"");
                }
            }

            @Override
            public void __show(PropId prop, boolean visible) {
                Visibility __visibility = (__modified!= null ? __modified : __base).__visibility;
                if (__visibility == null) {
                    if (visible) {
                        return;
                    }
                    __modified().__visibility = __visibility = Visibility.of(10);
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
                    case SLOT_ROLE_ID:
                    		__visibility.show(SLOT_ROLE_ID, visible);break;
                    case SLOT_ROLE_CODE:
                    		__visibility.show(SLOT_ROLE_CODE, visible);break;
                    case SLOT_P_CODE:
                    		__visibility.show(SLOT_P_CODE, visible);break;
                    case SLOT_ROLE_NAME:
                    		__visibility.show(SLOT_ROLE_NAME, visible);break;
                    case SLOT_STATUS:
                    		__visibility.show(SLOT_STATUS, visible);break;
                    default: throw new IllegalArgumentException(
                                "Illegal property id for \"com.leaf.domain.LeafRole\": \"" + 
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
                    __modified().__visibility = __visibility = Visibility.of(10);
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
                    case "roleId":
                    		__visibility.show(SLOT_ROLE_ID, visible);break;
                    case "roleCode":
                    		__visibility.show(SLOT_ROLE_CODE, visible);break;
                    case "pCode":
                    		__visibility.show(SLOT_P_CODE, visible);break;
                    case "roleName":
                    		__visibility.show(SLOT_ROLE_NAME, visible);break;
                    case "status":
                    		__visibility.show(SLOT_STATUS, visible);break;
                    default: throw new IllegalArgumentException(
                                "Illegal property name for \"com.leaf.domain.LeafRole\": \"" + 
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
                    case SLOT_ROLE_ID:
                    		__modified().__roleIdLoaded = false;break;
                    case SLOT_ROLE_CODE:
                    		__modified().__roleCodeValue = null;break;
                    case SLOT_P_CODE:
                    		__modified().__pCodeValue = null;break;
                    case SLOT_ROLE_NAME:
                    		__modified().__roleNameValue = null;break;
                    case SLOT_STATUS:
                    		__modified().__statusLoaded = false;break;
                    default: throw new IllegalArgumentException("Illegal property id for \"com.leaf.domain.LeafRole\": \"" + prop + "\", it does not exist or its loaded state is not controllable");
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
                    case "roleId":
                    		__modified().__roleIdLoaded = false;break;
                    case "roleCode":
                    		__modified().__roleCodeValue = null;break;
                    case "pCode":
                    		__modified().__pCodeValue = null;break;
                    case "roleName":
                    		__modified().__roleNameValue = null;break;
                    case "status":
                    		__modified().__statusLoaded = false;break;
                    default: throw new IllegalArgumentException("Illegal property name for \"com.leaf.domain.LeafRole\": \"" + prop + "\", it does not exist or its loaded state is not controllable");
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
        private Long roleId;

        private LocalDateTime createTime;

        private LocalDateTime updateTime;

        private boolean __createByLoaded;

        private LeafUser createBy;

        private boolean __updateByLoaded;

        private LeafUser updateBy;

        private String remark;

        private String roleCode;

        private String pCode;

        private String roleName;

        private boolean __statusLoaded;

        private Integer status;

        public MapStruct roleId(Long roleId) {
            this.roleId = roleId;
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

        public MapStruct roleCode(String roleCode) {
            this.roleCode = roleCode;
            return this;
        }

        public MapStruct pCode(String pCode) {
            this.pCode = pCode;
            return this;
        }

        public MapStruct roleName(String roleName) {
            this.roleName = roleName;
            return this;
        }

        public MapStruct status(Integer status) {
            this.__statusLoaded = true;
            this.status = status;
            return this;
        }

        public LeafRole build() {
            return LeafRoleDraft.$.produce(__draft -> {
                if (roleId != null) {
                    __draft.setRoleId(roleId);
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
                if (roleCode != null) {
                    __draft.setRoleCode(roleCode);
                }
                if (pCode != null) {
                    __draft.setPCode(pCode);
                }
                if (roleName != null) {
                    __draft.setRoleName(roleName);
                }
                if (__statusLoaded) {
                    __draft.setStatus(status);
                }
            });
        }
    }
}
