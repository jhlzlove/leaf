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
import org.jetbrains.annotations.Nullable;

@GeneratedBy(
        type = LeafDept.class
)
public interface LeafDeptDraft extends LeafDept, BaseEntityDraft {
    LeafDeptDraft.Producer $ = Producer.INSTANCE;

    @OldChain
    LeafDeptDraft setDeptId(long deptId);

    @OldChain
    LeafDeptDraft setCreateTime(LocalDateTime createTime);

    @OldChain
    LeafDeptDraft setUpdateTime(LocalDateTime updateTime);

    @OldChain
    LeafDeptDraft setCreateBy(String createBy);

    @OldChain
    LeafDeptDraft setUpdateBy(String updateBy);

    @OldChain
    LeafDeptDraft setRemark(String remark);

    @OldChain
    LeafDeptDraft setDeptName(String deptName);

    @OldChain
    LeafDeptDraft setParentId(Long parentId);

    @OldChain
    LeafDeptDraft setDeptCode(String deptCode);

    @OldChain
    LeafDeptDraft setLeaderId(Long leaderId);

    @OldChain
    LeafDeptDraft setDescription(String description);

    @OldChain
    LeafDeptDraft setStatus(int status);

    @OldChain
    LeafDeptDraft setSortable(Integer sortable);

    @OldChain
    LeafDeptDraft setRoleId(Long roleId);

    List<LeafUserDraft> userList(boolean autoCreate);

    @OldChain
    LeafDeptDraft setUserList(List<LeafUser> userList);

    @OldChain
    LeafDeptDraft addIntoUserList(DraftConsumer<LeafUserDraft> block);

    @OldChain
    LeafDeptDraft addIntoUserList(LeafUser base, DraftConsumer<LeafUserDraft> block);

    class Producer {
        static final Producer INSTANCE = new Producer();

        public static final int SLOT_DEPT_ID = 5;

        public static final int SLOT_CREATE_TIME = 0;

        public static final int SLOT_UPDATE_TIME = 1;

        public static final int SLOT_CREATE_BY = 2;

        public static final int SLOT_UPDATE_BY = 3;

        public static final int SLOT_REMARK = 4;

        public static final int SLOT_DEPT_NAME = 6;

        public static final int SLOT_PARENT_ID = 7;

        public static final int SLOT_DEPT_CODE = 8;

        public static final int SLOT_LEADER_ID = 9;

        public static final int SLOT_DESCRIPTION = 10;

        public static final int SLOT_STATUS = 11;

        public static final int SLOT_SORTABLE = 12;

        public static final int SLOT_ROLE_ID = 13;

        public static final int SLOT_USER_LIST = 14;

        public static final ImmutableType TYPE = ImmutableType
            .newBuilder(
                "0.8.125",
                LeafDept.class,
                Collections.singleton(BaseEntityDraft.Producer.TYPE),
                (ctx, base) -> new DraftImpl(ctx, (LeafDept)base)
            )
            .redefine("createTime", SLOT_CREATE_TIME)
            .redefine("updateTime", SLOT_UPDATE_TIME)
            .redefine("createBy", SLOT_CREATE_BY)
            .redefine("updateBy", SLOT_UPDATE_BY)
            .redefine("remark", SLOT_REMARK)
            .id(SLOT_DEPT_ID, "deptId", long.class)
            .add(SLOT_DEPT_NAME, "deptName", ImmutablePropCategory.SCALAR, String.class, false)
            .add(SLOT_PARENT_ID, "parentId", ImmutablePropCategory.SCALAR, Long.class, true)
            .add(SLOT_DEPT_CODE, "deptCode", ImmutablePropCategory.SCALAR, String.class, false)
            .add(SLOT_LEADER_ID, "leaderId", ImmutablePropCategory.SCALAR, Long.class, true)
            .add(SLOT_DESCRIPTION, "description", ImmutablePropCategory.SCALAR, String.class, true)
            .add(SLOT_STATUS, "status", ImmutablePropCategory.SCALAR, int.class, false)
            .add(SLOT_SORTABLE, "sortable", ImmutablePropCategory.SCALAR, Integer.class, true)
            .add(SLOT_ROLE_ID, "roleId", ImmutablePropCategory.SCALAR, Long.class, true)
            .add(SLOT_USER_LIST, "userList", ManyToMany.class, LeafUser.class, false)
            .build();

        private Producer() {
        }

        public LeafDept produce(DraftConsumer<LeafDeptDraft> block) {
            return produce(null, block);
        }

        public LeafDept produce(LeafDept base, DraftConsumer<LeafDeptDraft> block) {
            return (LeafDept)Internal.produce(TYPE, base, block);
        }

        @JsonPropertyOrder({"dummyPropForJacksonError__", "createTime", "updateTime", "createBy", "updateBy", "remark", "deptId", "deptName", "parentId", "deptCode", "leaderId", "description", "status", "sortable", "roleId", "userList"})
        public abstract interface Implementor extends LeafDept, ImmutableSpi {
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
                    case SLOT_DEPT_ID:
                    		return (Long)deptId();
                    case SLOT_DEPT_NAME:
                    		return deptName();
                    case SLOT_PARENT_ID:
                    		return parentId();
                    case SLOT_DEPT_CODE:
                    		return deptCode();
                    case SLOT_LEADER_ID:
                    		return leaderId();
                    case SLOT_DESCRIPTION:
                    		return description();
                    case SLOT_STATUS:
                    		return (Integer)status();
                    case SLOT_SORTABLE:
                    		return sortable();
                    case SLOT_ROLE_ID:
                    		return roleId();
                    case SLOT_USER_LIST:
                    		return userList();
                    default: throw new IllegalArgumentException("Illegal property name for \"com.leaf.domain.LeafDept\": \"" + prop + "\"");
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
                    case "deptId":
                    		return (Long)deptId();
                    case "deptName":
                    		return deptName();
                    case "parentId":
                    		return parentId();
                    case "deptCode":
                    		return deptCode();
                    case "leaderId":
                    		return leaderId();
                    case "description":
                    		return description();
                    case "status":
                    		return (Integer)status();
                    case "sortable":
                    		return sortable();
                    case "roleId":
                    		return roleId();
                    case "userList":
                    		return userList();
                    default: throw new IllegalArgumentException("Illegal property name for \"com.leaf.domain.LeafDept\": \"" + prop + "\"");
                }
            }

            default long getDeptId() {
                return deptId();
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

            default String getDeptName() {
                return deptName();
            }

            default Long getParentId() {
                return parentId();
            }

            default String getDeptCode() {
                return deptCode();
            }

            default Long getLeaderId() {
                return leaderId();
            }

            @Nullable
            default String getDescription() {
                return description();
            }

            default int getStatus() {
                return status();
            }

            default Integer getSortable() {
                return sortable();
            }

            default Long getRoleId() {
                return roleId();
            }

            default List<LeafUser> getUserList() {
                return userList();
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

            long __deptIdValue;

            boolean __deptIdLoaded = false;

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

            String __deptNameValue;

            Long __parentIdValue;

            boolean __parentIdLoaded = false;

            String __deptCodeValue;

            Long __leaderIdValue;

            boolean __leaderIdLoaded = false;

            String __descriptionValue;

            boolean __descriptionLoaded = false;

            int __statusValue;

            boolean __statusLoaded = false;

            Integer __sortableValue;

            boolean __sortableLoaded = false;

            Long __roleIdValue;

            boolean __roleIdLoaded = false;

            NonSharedList<LeafUser> __userListValue;

            @Override
            @JsonIgnore
            public long deptId() {
                if (!__deptIdLoaded) {
                    throw new UnloadedException(LeafDept.class, "deptId");
                }
                return __deptIdValue;
            }

            @Override
            @JsonIgnore
            @Nullable
            public LocalDateTime createTime() {
                if (!__createTimeLoaded) {
                    throw new UnloadedException(LeafDept.class, "createTime");
                }
                return __createTimeValue;
            }

            @Override
            @JsonIgnore
            @Nullable
            public LocalDateTime updateTime() {
                if (!__updateTimeLoaded) {
                    throw new UnloadedException(LeafDept.class, "updateTime");
                }
                return __updateTimeValue;
            }

            @Override
            @JsonIgnore
            @Nullable
            public String createBy() {
                if (!__createByLoaded) {
                    throw new UnloadedException(LeafDept.class, "createBy");
                }
                return __createByValue;
            }

            @Override
            @JsonIgnore
            @Nullable
            public String updateBy() {
                if (!__updateByLoaded) {
                    throw new UnloadedException(LeafDept.class, "updateBy");
                }
                return __updateByValue;
            }

            @Override
            @JsonIgnore
            @Nullable
            public String remark() {
                if (!__remarkLoaded) {
                    throw new UnloadedException(LeafDept.class, "remark");
                }
                return __remarkValue;
            }

            @Override
            @JsonIgnore
            public String deptName() {
                if (__deptNameValue == null) {
                    throw new UnloadedException(LeafDept.class, "deptName");
                }
                return __deptNameValue;
            }

            @Override
            @JsonIgnore
            @Nullable
            public Long parentId() {
                if (!__parentIdLoaded) {
                    throw new UnloadedException(LeafDept.class, "parentId");
                }
                return __parentIdValue;
            }

            @Override
            @JsonIgnore
            public String deptCode() {
                if (__deptCodeValue == null) {
                    throw new UnloadedException(LeafDept.class, "deptCode");
                }
                return __deptCodeValue;
            }

            @Override
            @JsonIgnore
            @Nullable
            public Long leaderId() {
                if (!__leaderIdLoaded) {
                    throw new UnloadedException(LeafDept.class, "leaderId");
                }
                return __leaderIdValue;
            }

            @Override
            @JsonIgnore
            @Nullable
            public String description() {
                if (!__descriptionLoaded) {
                    throw new UnloadedException(LeafDept.class, "description");
                }
                return __descriptionValue;
            }

            @Override
            @JsonIgnore
            public int status() {
                if (!__statusLoaded) {
                    throw new UnloadedException(LeafDept.class, "status");
                }
                return __statusValue;
            }

            @Override
            @JsonIgnore
            @Nullable
            public Integer sortable() {
                if (!__sortableLoaded) {
                    throw new UnloadedException(LeafDept.class, "sortable");
                }
                return __sortableValue;
            }

            @Override
            @JsonIgnore
            @Nullable
            public Long roleId() {
                if (!__roleIdLoaded) {
                    throw new UnloadedException(LeafDept.class, "roleId");
                }
                return __roleIdValue;
            }

            @Override
            @JsonIgnore
            public List<LeafUser> userList() {
                if (__userListValue == null) {
                    throw new UnloadedException(LeafDept.class, "userList");
                }
                return __userListValue;
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
                    case SLOT_DEPT_ID:
                    		return __deptIdLoaded;
                    case SLOT_DEPT_NAME:
                    		return __deptNameValue != null;
                    case SLOT_PARENT_ID:
                    		return __parentIdLoaded;
                    case SLOT_DEPT_CODE:
                    		return __deptCodeValue != null;
                    case SLOT_LEADER_ID:
                    		return __leaderIdLoaded;
                    case SLOT_DESCRIPTION:
                    		return __descriptionLoaded;
                    case SLOT_STATUS:
                    		return __statusLoaded;
                    case SLOT_SORTABLE:
                    		return __sortableLoaded;
                    case SLOT_ROLE_ID:
                    		return __roleIdLoaded;
                    case SLOT_USER_LIST:
                    		return __userListValue != null;
                    default: throw new IllegalArgumentException("Illegal property name for \"com.leaf.domain.LeafDept\": \"" + prop + "\"");
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
                    case "deptId":
                    		return __deptIdLoaded;
                    case "deptName":
                    		return __deptNameValue != null;
                    case "parentId":
                    		return __parentIdLoaded;
                    case "deptCode":
                    		return __deptCodeValue != null;
                    case "leaderId":
                    		return __leaderIdLoaded;
                    case "description":
                    		return __descriptionLoaded;
                    case "status":
                    		return __statusLoaded;
                    case "sortable":
                    		return __sortableLoaded;
                    case "roleId":
                    		return __roleIdLoaded;
                    case "userList":
                    		return __userListValue != null;
                    default: throw new IllegalArgumentException("Illegal property name for \"com.leaf.domain.LeafDept\": \"" + prop + "\"");
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
                    case SLOT_DEPT_ID:
                    		return __visibility.visible(SLOT_DEPT_ID);
                    case SLOT_DEPT_NAME:
                    		return __visibility.visible(SLOT_DEPT_NAME);
                    case SLOT_PARENT_ID:
                    		return __visibility.visible(SLOT_PARENT_ID);
                    case SLOT_DEPT_CODE:
                    		return __visibility.visible(SLOT_DEPT_CODE);
                    case SLOT_LEADER_ID:
                    		return __visibility.visible(SLOT_LEADER_ID);
                    case SLOT_DESCRIPTION:
                    		return __visibility.visible(SLOT_DESCRIPTION);
                    case SLOT_STATUS:
                    		return __visibility.visible(SLOT_STATUS);
                    case SLOT_SORTABLE:
                    		return __visibility.visible(SLOT_SORTABLE);
                    case SLOT_ROLE_ID:
                    		return __visibility.visible(SLOT_ROLE_ID);
                    case SLOT_USER_LIST:
                    		return __visibility.visible(SLOT_USER_LIST);
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
                    case "deptId":
                    		return __visibility.visible(SLOT_DEPT_ID);
                    case "deptName":
                    		return __visibility.visible(SLOT_DEPT_NAME);
                    case "parentId":
                    		return __visibility.visible(SLOT_PARENT_ID);
                    case "deptCode":
                    		return __visibility.visible(SLOT_DEPT_CODE);
                    case "leaderId":
                    		return __visibility.visible(SLOT_LEADER_ID);
                    case "description":
                    		return __visibility.visible(SLOT_DESCRIPTION);
                    case "status":
                    		return __visibility.visible(SLOT_STATUS);
                    case "sortable":
                    		return __visibility.visible(SLOT_SORTABLE);
                    case "roleId":
                    		return __visibility.visible(SLOT_ROLE_ID);
                    case "userList":
                    		return __visibility.visible(SLOT_USER_LIST);
                    default: return true;
                }
            }

            @Override
            public int hashCode() {
                int hash = __visibility != null ? __visibility.hashCode() : 0;
                if (__deptIdLoaded) {
                    hash = 31 * hash + Long.hashCode(__deptIdValue);
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
                if (__deptNameValue != null) {
                    hash = 31 * hash + __deptNameValue.hashCode();
                }
                if (__parentIdLoaded && __parentIdValue != null) {
                    hash = 31 * hash + __parentIdValue.hashCode();
                }
                if (__deptCodeValue != null) {
                    hash = 31 * hash + __deptCodeValue.hashCode();
                }
                if (__leaderIdLoaded && __leaderIdValue != null) {
                    hash = 31 * hash + __leaderIdValue.hashCode();
                }
                if (__descriptionLoaded && __descriptionValue != null) {
                    hash = 31 * hash + __descriptionValue.hashCode();
                }
                if (__statusLoaded) {
                    hash = 31 * hash + Integer.hashCode(__statusValue);
                }
                if (__sortableLoaded && __sortableValue != null) {
                    hash = 31 * hash + __sortableValue.hashCode();
                }
                if (__roleIdLoaded && __roleIdValue != null) {
                    hash = 31 * hash + __roleIdValue.hashCode();
                }
                if (__userListValue != null) {
                    hash = 31 * hash + __userListValue.hashCode();
                }
                return hash;
            }

            private int __shallowHashCode() {
                int hash = __visibility != null ? __visibility.hashCode() : 0;
                if (__deptIdLoaded) {
                    hash = 31 * hash + Long.hashCode(__deptIdValue);
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
                if (__deptNameValue != null) {
                    hash = 31 * hash + System.identityHashCode(__deptNameValue);
                }
                if (__parentIdLoaded) {
                    hash = 31 * hash + System.identityHashCode(__parentIdValue);
                }
                if (__deptCodeValue != null) {
                    hash = 31 * hash + System.identityHashCode(__deptCodeValue);
                }
                if (__leaderIdLoaded) {
                    hash = 31 * hash + System.identityHashCode(__leaderIdValue);
                }
                if (__descriptionLoaded) {
                    hash = 31 * hash + System.identityHashCode(__descriptionValue);
                }
                if (__statusLoaded) {
                    hash = 31 * hash + Integer.hashCode(__statusValue);
                }
                if (__sortableLoaded) {
                    hash = 31 * hash + System.identityHashCode(__sortableValue);
                }
                if (__roleIdLoaded) {
                    hash = 31 * hash + System.identityHashCode(__roleIdValue);
                }
                if (__userListValue != null) {
                    hash = 31 * hash + System.identityHashCode(__userListValue);
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
                if (__isVisible(PropId.byIndex(SLOT_DEPT_ID)) != __other.__isVisible(PropId.byIndex(SLOT_DEPT_ID))) {
                    return false;
                }
                boolean __deptIdLoaded = this.__deptIdLoaded;
                if (__deptIdLoaded != __other.__isLoaded(PropId.byIndex(SLOT_DEPT_ID))) {
                    return false;
                }
                if (__deptIdLoaded) {
                    // If entity-id is loaded, return directly
                    return __deptIdValue == __other.deptId();
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
                if (__isVisible(PropId.byIndex(SLOT_DEPT_NAME)) != __other.__isVisible(PropId.byIndex(SLOT_DEPT_NAME))) {
                    return false;
                }
                boolean __deptNameLoaded = __deptNameValue != null;
                if (__deptNameLoaded != __other.__isLoaded(PropId.byIndex(SLOT_DEPT_NAME))) {
                    return false;
                }
                if (__deptNameLoaded && !Objects.equals(__deptNameValue, __other.deptName())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_PARENT_ID)) != __other.__isVisible(PropId.byIndex(SLOT_PARENT_ID))) {
                    return false;
                }
                boolean __parentIdLoaded = this.__parentIdLoaded;
                if (__parentIdLoaded != __other.__isLoaded(PropId.byIndex(SLOT_PARENT_ID))) {
                    return false;
                }
                if (__parentIdLoaded && !Objects.equals(__parentIdValue, __other.parentId())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_DEPT_CODE)) != __other.__isVisible(PropId.byIndex(SLOT_DEPT_CODE))) {
                    return false;
                }
                boolean __deptCodeLoaded = __deptCodeValue != null;
                if (__deptCodeLoaded != __other.__isLoaded(PropId.byIndex(SLOT_DEPT_CODE))) {
                    return false;
                }
                if (__deptCodeLoaded && !Objects.equals(__deptCodeValue, __other.deptCode())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_LEADER_ID)) != __other.__isVisible(PropId.byIndex(SLOT_LEADER_ID))) {
                    return false;
                }
                boolean __leaderIdLoaded = this.__leaderIdLoaded;
                if (__leaderIdLoaded != __other.__isLoaded(PropId.byIndex(SLOT_LEADER_ID))) {
                    return false;
                }
                if (__leaderIdLoaded && !Objects.equals(__leaderIdValue, __other.leaderId())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_DESCRIPTION)) != __other.__isVisible(PropId.byIndex(SLOT_DESCRIPTION))) {
                    return false;
                }
                boolean __descriptionLoaded = this.__descriptionLoaded;
                if (__descriptionLoaded != __other.__isLoaded(PropId.byIndex(SLOT_DESCRIPTION))) {
                    return false;
                }
                if (__descriptionLoaded && !Objects.equals(__descriptionValue, __other.description())) {
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
                if (__isVisible(PropId.byIndex(SLOT_SORTABLE)) != __other.__isVisible(PropId.byIndex(SLOT_SORTABLE))) {
                    return false;
                }
                boolean __sortableLoaded = this.__sortableLoaded;
                if (__sortableLoaded != __other.__isLoaded(PropId.byIndex(SLOT_SORTABLE))) {
                    return false;
                }
                if (__sortableLoaded && !Objects.equals(__sortableValue, __other.sortable())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_ROLE_ID)) != __other.__isVisible(PropId.byIndex(SLOT_ROLE_ID))) {
                    return false;
                }
                boolean __roleIdLoaded = this.__roleIdLoaded;
                if (__roleIdLoaded != __other.__isLoaded(PropId.byIndex(SLOT_ROLE_ID))) {
                    return false;
                }
                if (__roleIdLoaded && !Objects.equals(__roleIdValue, __other.roleId())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_USER_LIST)) != __other.__isVisible(PropId.byIndex(SLOT_USER_LIST))) {
                    return false;
                }
                boolean __userListLoaded = __userListValue != null;
                if (__userListLoaded != __other.__isLoaded(PropId.byIndex(SLOT_USER_LIST))) {
                    return false;
                }
                if (__userListLoaded && !Objects.equals(__userListValue, __other.userList())) {
                    return false;
                }
                return true;
            }

            private boolean __shallowEquals(Object obj) {
                if (obj == null || !(obj instanceof Implementor)) {
                    return false;
                }
                Implementor __other = (Implementor)obj;
                if (__isVisible(PropId.byIndex(SLOT_DEPT_ID)) != __other.__isVisible(PropId.byIndex(SLOT_DEPT_ID))) {
                    return false;
                }
                boolean __deptIdLoaded = this.__deptIdLoaded;
                if (__deptIdLoaded != __other.__isLoaded(PropId.byIndex(SLOT_DEPT_ID))) {
                    return false;
                }
                if (__deptIdLoaded && __deptIdValue != __other.deptId()) {
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
                if (__isVisible(PropId.byIndex(SLOT_DEPT_NAME)) != __other.__isVisible(PropId.byIndex(SLOT_DEPT_NAME))) {
                    return false;
                }
                boolean __deptNameLoaded = __deptNameValue != null;
                if (__deptNameLoaded != __other.__isLoaded(PropId.byIndex(SLOT_DEPT_NAME))) {
                    return false;
                }
                if (__deptNameLoaded && __deptNameValue != __other.deptName()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_PARENT_ID)) != __other.__isVisible(PropId.byIndex(SLOT_PARENT_ID))) {
                    return false;
                }
                boolean __parentIdLoaded = this.__parentIdLoaded;
                if (__parentIdLoaded != __other.__isLoaded(PropId.byIndex(SLOT_PARENT_ID))) {
                    return false;
                }
                if (__parentIdLoaded && __parentIdValue != __other.parentId()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_DEPT_CODE)) != __other.__isVisible(PropId.byIndex(SLOT_DEPT_CODE))) {
                    return false;
                }
                boolean __deptCodeLoaded = __deptCodeValue != null;
                if (__deptCodeLoaded != __other.__isLoaded(PropId.byIndex(SLOT_DEPT_CODE))) {
                    return false;
                }
                if (__deptCodeLoaded && __deptCodeValue != __other.deptCode()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_LEADER_ID)) != __other.__isVisible(PropId.byIndex(SLOT_LEADER_ID))) {
                    return false;
                }
                boolean __leaderIdLoaded = this.__leaderIdLoaded;
                if (__leaderIdLoaded != __other.__isLoaded(PropId.byIndex(SLOT_LEADER_ID))) {
                    return false;
                }
                if (__leaderIdLoaded && __leaderIdValue != __other.leaderId()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_DESCRIPTION)) != __other.__isVisible(PropId.byIndex(SLOT_DESCRIPTION))) {
                    return false;
                }
                boolean __descriptionLoaded = this.__descriptionLoaded;
                if (__descriptionLoaded != __other.__isLoaded(PropId.byIndex(SLOT_DESCRIPTION))) {
                    return false;
                }
                if (__descriptionLoaded && __descriptionValue != __other.description()) {
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
                if (__isVisible(PropId.byIndex(SLOT_SORTABLE)) != __other.__isVisible(PropId.byIndex(SLOT_SORTABLE))) {
                    return false;
                }
                boolean __sortableLoaded = this.__sortableLoaded;
                if (__sortableLoaded != __other.__isLoaded(PropId.byIndex(SLOT_SORTABLE))) {
                    return false;
                }
                if (__sortableLoaded && __sortableValue != __other.sortable()) {
                    return false;
                }
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
                if (__isVisible(PropId.byIndex(SLOT_USER_LIST)) != __other.__isVisible(PropId.byIndex(SLOT_USER_LIST))) {
                    return false;
                }
                boolean __userListLoaded = __userListValue != null;
                if (__userListLoaded != __other.__isLoaded(PropId.byIndex(SLOT_USER_LIST))) {
                    return false;
                }
                if (__userListLoaded && __userListValue != __other.userList()) {
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

        private static class DraftImpl implements Implementor, DraftSpi, LeafDeptDraft {
            private DraftContext __ctx;

            private Impl __base;

            private Impl __modified;

            private boolean __resolving;

            DraftImpl(DraftContext ctx, LeafDept base) {
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
            public long deptId() {
                return (__modified!= null ? __modified : __base).deptId();
            }

            @Override
            public LeafDeptDraft setDeptId(long deptId) {
                Impl __tmpModified = __modified();
                __tmpModified.__deptIdValue = deptId;
                __tmpModified.__deptIdLoaded = true;
                return this;
            }

            @Override
            @JsonIgnore
            @Nullable
            public LocalDateTime createTime() {
                return (__modified!= null ? __modified : __base).createTime();
            }

            @Override
            public LeafDeptDraft setCreateTime(LocalDateTime createTime) {
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
            public LeafDeptDraft setUpdateTime(LocalDateTime updateTime) {
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
            public LeafDeptDraft setCreateBy(String createBy) {
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
            public LeafDeptDraft setUpdateBy(String updateBy) {
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
            public LeafDeptDraft setRemark(String remark) {
                Impl __tmpModified = __modified();
                __tmpModified.__remarkValue = remark;
                __tmpModified.__remarkLoaded = true;
                return this;
            }

            @Override
            @JsonIgnore
            public String deptName() {
                return (__modified!= null ? __modified : __base).deptName();
            }

            @Override
            public LeafDeptDraft setDeptName(String deptName) {
                if (deptName == null) {
                    throw new IllegalArgumentException(
                        "'deptName' cannot be null, please specify non-null value or use nullable annotation to decorate this property"
                    );
                }
                Impl __tmpModified = __modified();
                __tmpModified.__deptNameValue = deptName;
                return this;
            }

            @Override
            @JsonIgnore
            @Nullable
            public Long parentId() {
                return (__modified!= null ? __modified : __base).parentId();
            }

            @Override
            public LeafDeptDraft setParentId(Long parentId) {
                Impl __tmpModified = __modified();
                __tmpModified.__parentIdValue = parentId;
                __tmpModified.__parentIdLoaded = true;
                return this;
            }

            @Override
            @JsonIgnore
            public String deptCode() {
                return (__modified!= null ? __modified : __base).deptCode();
            }

            @Override
            public LeafDeptDraft setDeptCode(String deptCode) {
                if (deptCode == null) {
                    throw new IllegalArgumentException(
                        "'deptCode' cannot be null, please specify non-null value or use nullable annotation to decorate this property"
                    );
                }
                Impl __tmpModified = __modified();
                __tmpModified.__deptCodeValue = deptCode;
                return this;
            }

            @Override
            @JsonIgnore
            @Nullable
            public Long leaderId() {
                return (__modified!= null ? __modified : __base).leaderId();
            }

            @Override
            public LeafDeptDraft setLeaderId(Long leaderId) {
                Impl __tmpModified = __modified();
                __tmpModified.__leaderIdValue = leaderId;
                __tmpModified.__leaderIdLoaded = true;
                return this;
            }

            @Override
            @JsonIgnore
            @Nullable
            public String description() {
                return (__modified!= null ? __modified : __base).description();
            }

            @Override
            public LeafDeptDraft setDescription(String description) {
                Impl __tmpModified = __modified();
                __tmpModified.__descriptionValue = description;
                __tmpModified.__descriptionLoaded = true;
                return this;
            }

            @Override
            @JsonIgnore
            public int status() {
                return (__modified!= null ? __modified : __base).status();
            }

            @Override
            public LeafDeptDraft setStatus(int status) {
                Impl __tmpModified = __modified();
                __tmpModified.__statusValue = status;
                __tmpModified.__statusLoaded = true;
                return this;
            }

            @Override
            @JsonIgnore
            @Nullable
            public Integer sortable() {
                return (__modified!= null ? __modified : __base).sortable();
            }

            @Override
            public LeafDeptDraft setSortable(Integer sortable) {
                Impl __tmpModified = __modified();
                __tmpModified.__sortableValue = sortable;
                __tmpModified.__sortableLoaded = true;
                return this;
            }

            @Override
            @JsonIgnore
            @Nullable
            public Long roleId() {
                return (__modified!= null ? __modified : __base).roleId();
            }

            @Override
            public LeafDeptDraft setRoleId(Long roleId) {
                Impl __tmpModified = __modified();
                __tmpModified.__roleIdValue = roleId;
                __tmpModified.__roleIdLoaded = true;
                return this;
            }

            @Override
            @JsonIgnore
            public List<LeafUser> userList() {
                return __ctx.toDraftList((__modified!= null ? __modified : __base).userList(), LeafUser.class, true);
            }

            @Override
            public List<LeafUserDraft> userList(boolean autoCreate) {
                if (autoCreate && (!__isLoaded(PropId.byIndex(SLOT_USER_LIST)))) {
                    setUserList(new ArrayList<>());
                }
                return __ctx.toDraftList((__modified!= null ? __modified : __base).userList(), LeafUser.class, true);
            }

            @Override
            public LeafDeptDraft setUserList(List<LeafUser> userList) {
                if (userList == null) {
                    throw new IllegalArgumentException(
                        "'userList' cannot be null, please specify non-null value or use nullable annotation to decorate this property"
                    );
                }
                Impl __tmpModified = __modified();
                __tmpModified.__userListValue = NonSharedList.of(__tmpModified.__userListValue, userList);
                return this;
            }

            @Override
            public LeafDeptDraft addIntoUserList(DraftConsumer<LeafUserDraft> block) {
                addIntoUserList(null, block);
                return this;
            }

            @Override
            public LeafDeptDraft addIntoUserList(LeafUser base,
                    DraftConsumer<LeafUserDraft> block) {
                userList(true).add((LeafUserDraft)LeafUserDraft.$.produce(base, block));
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
                    case SLOT_DEPT_ID:
                    		if (value == null) throw new IllegalArgumentException("'deptId' cannot be null, if you want to set null, please use any annotation whose simple name is \"Nullable\" to decorate the property");
                            setDeptId((Long)value);
                            break;
                    case SLOT_DEPT_NAME:
                    		setDeptName((String)value);break;
                    case SLOT_PARENT_ID:
                    		setParentId((Long)value);break;
                    case SLOT_DEPT_CODE:
                    		setDeptCode((String)value);break;
                    case SLOT_LEADER_ID:
                    		setLeaderId((Long)value);break;
                    case SLOT_DESCRIPTION:
                    		setDescription((String)value);break;
                    case SLOT_STATUS:
                    		if (value == null) throw new IllegalArgumentException("'status' cannot be null, if you want to set null, please use any annotation whose simple name is \"Nullable\" to decorate the property");
                            setStatus((Integer)value);
                            break;
                    case SLOT_SORTABLE:
                    		setSortable((Integer)value);break;
                    case SLOT_ROLE_ID:
                    		setRoleId((Long)value);break;
                    case SLOT_USER_LIST:
                    		setUserList((List<LeafUser>)value);break;
                    default: throw new IllegalArgumentException("Illegal property id for \"com.leaf.domain.LeafDept\": \"" + prop + "\"");
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
                    case "deptId":
                    		if (value == null) throw new IllegalArgumentException("'deptId' cannot be null, if you want to set null, please use any annotation whose simple name is \"Nullable\" to decorate the property");
                            setDeptId((Long)value);
                            break;
                    case "deptName":
                    		setDeptName((String)value);break;
                    case "parentId":
                    		setParentId((Long)value);break;
                    case "deptCode":
                    		setDeptCode((String)value);break;
                    case "leaderId":
                    		setLeaderId((Long)value);break;
                    case "description":
                    		setDescription((String)value);break;
                    case "status":
                    		if (value == null) throw new IllegalArgumentException("'status' cannot be null, if you want to set null, please use any annotation whose simple name is \"Nullable\" to decorate the property");
                            setStatus((Integer)value);
                            break;
                    case "sortable":
                    		setSortable((Integer)value);break;
                    case "roleId":
                    		setRoleId((Long)value);break;
                    case "userList":
                    		setUserList((List<LeafUser>)value);break;
                    default: throw new IllegalArgumentException("Illegal property name for \"com.leaf.domain.LeafDept\": \"" + prop + "\"");
                }
            }

            @Override
            public void __show(PropId prop, boolean visible) {
                Visibility __visibility = (__modified!= null ? __modified : __base).__visibility;
                if (__visibility == null) {
                    if (visible) {
                        return;
                    }
                    __modified().__visibility = __visibility = Visibility.of(15);
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
                    case SLOT_DEPT_ID:
                    		__visibility.show(SLOT_DEPT_ID, visible);break;
                    case SLOT_DEPT_NAME:
                    		__visibility.show(SLOT_DEPT_NAME, visible);break;
                    case SLOT_PARENT_ID:
                    		__visibility.show(SLOT_PARENT_ID, visible);break;
                    case SLOT_DEPT_CODE:
                    		__visibility.show(SLOT_DEPT_CODE, visible);break;
                    case SLOT_LEADER_ID:
                    		__visibility.show(SLOT_LEADER_ID, visible);break;
                    case SLOT_DESCRIPTION:
                    		__visibility.show(SLOT_DESCRIPTION, visible);break;
                    case SLOT_STATUS:
                    		__visibility.show(SLOT_STATUS, visible);break;
                    case SLOT_SORTABLE:
                    		__visibility.show(SLOT_SORTABLE, visible);break;
                    case SLOT_ROLE_ID:
                    		__visibility.show(SLOT_ROLE_ID, visible);break;
                    case SLOT_USER_LIST:
                    		__visibility.show(SLOT_USER_LIST, visible);break;
                    default: throw new IllegalArgumentException(
                                "Illegal property id for \"com.leaf.domain.LeafDept\": \"" + 
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
                    __modified().__visibility = __visibility = Visibility.of(15);
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
                    case "deptId":
                    		__visibility.show(SLOT_DEPT_ID, visible);break;
                    case "deptName":
                    		__visibility.show(SLOT_DEPT_NAME, visible);break;
                    case "parentId":
                    		__visibility.show(SLOT_PARENT_ID, visible);break;
                    case "deptCode":
                    		__visibility.show(SLOT_DEPT_CODE, visible);break;
                    case "leaderId":
                    		__visibility.show(SLOT_LEADER_ID, visible);break;
                    case "description":
                    		__visibility.show(SLOT_DESCRIPTION, visible);break;
                    case "status":
                    		__visibility.show(SLOT_STATUS, visible);break;
                    case "sortable":
                    		__visibility.show(SLOT_SORTABLE, visible);break;
                    case "roleId":
                    		__visibility.show(SLOT_ROLE_ID, visible);break;
                    case "userList":
                    		__visibility.show(SLOT_USER_LIST, visible);break;
                    default: throw new IllegalArgumentException(
                                "Illegal property name for \"com.leaf.domain.LeafDept\": \"" + 
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
                    case SLOT_DEPT_ID:
                    		__modified().__deptIdLoaded = false;break;
                    case SLOT_DEPT_NAME:
                    		__modified().__deptNameValue = null;break;
                    case SLOT_PARENT_ID:
                    		__modified().__parentIdLoaded = false;break;
                    case SLOT_DEPT_CODE:
                    		__modified().__deptCodeValue = null;break;
                    case SLOT_LEADER_ID:
                    		__modified().__leaderIdLoaded = false;break;
                    case SLOT_DESCRIPTION:
                    		__modified().__descriptionLoaded = false;break;
                    case SLOT_STATUS:
                    		__modified().__statusLoaded = false;break;
                    case SLOT_SORTABLE:
                    		__modified().__sortableLoaded = false;break;
                    case SLOT_ROLE_ID:
                    		__modified().__roleIdLoaded = false;break;
                    case SLOT_USER_LIST:
                    		__modified().__userListValue = null;break;
                    default: throw new IllegalArgumentException("Illegal property id for \"com.leaf.domain.LeafDept\": \"" + prop + "\", it does not exist or its loaded state is not controllable");
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
                    case "deptId":
                    		__modified().__deptIdLoaded = false;break;
                    case "deptName":
                    		__modified().__deptNameValue = null;break;
                    case "parentId":
                    		__modified().__parentIdLoaded = false;break;
                    case "deptCode":
                    		__modified().__deptCodeValue = null;break;
                    case "leaderId":
                    		__modified().__leaderIdLoaded = false;break;
                    case "description":
                    		__modified().__descriptionLoaded = false;break;
                    case "status":
                    		__modified().__statusLoaded = false;break;
                    case "sortable":
                    		__modified().__sortableLoaded = false;break;
                    case "roleId":
                    		__modified().__roleIdLoaded = false;break;
                    case "userList":
                    		__modified().__userListValue = null;break;
                    default: throw new IllegalArgumentException("Illegal property name for \"com.leaf.domain.LeafDept\": \"" + prop + "\", it does not exist or its loaded state is not controllable");
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
                        if (base.__isLoaded(PropId.byIndex(SLOT_USER_LIST))) {
                            List<LeafUser> oldValue = base.userList();
                            List<LeafUser> newValue = __ctx.resolveList(oldValue);
                            if (oldValue != newValue) {
                                setUserList(newValue);
                            }
                        }
                        __tmpModified = __modified;
                    }
                    else {
                        __tmpModified.__userListValue = NonSharedList.of(__tmpModified.__userListValue, __ctx.resolveList(__tmpModified.__userListValue));
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
        }

        public Builder deptId(Long deptId) {
            if (deptId != null) {
                __draft.setDeptId(deptId);
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

        public Builder deptName(String deptName) {
            if (deptName != null) {
                __draft.setDeptName(deptName);
            }
            return this;
        }

        public Builder parentId(Long parentId) {
            __draft.setParentId(parentId);
            return this;
        }

        public Builder deptCode(String deptCode) {
            if (deptCode != null) {
                __draft.setDeptCode(deptCode);
            }
            return this;
        }

        public Builder leaderId(Long leaderId) {
            __draft.setLeaderId(leaderId);
            return this;
        }

        @Nullable
        public Builder description(String description) {
            __draft.setDescription(description);
            return this;
        }

        public Builder status(Integer status) {
            if (status != null) {
                __draft.setStatus(status);
            }
            return this;
        }

        public Builder sortable(Integer sortable) {
            __draft.setSortable(sortable);
            return this;
        }

        public Builder roleId(Long roleId) {
            __draft.setRoleId(roleId);
            return this;
        }

        public Builder userList(List<LeafUser> userList) {
            if (userList != null) {
                __draft.setUserList(userList);
            }
            return this;
        }

        public LeafDept build() {
            return (LeafDept)__draft.__modified();
        }
    }
}
