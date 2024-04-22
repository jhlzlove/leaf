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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.babyfish.jimmer.CircularReferenceException;
import org.babyfish.jimmer.Draft;
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
import org.babyfish.jimmer.sql.OneToMany;
import org.jetbrains.annotations.Nullable;

@GeneratedBy(
        type = LeafUserDetail.class
)
public interface LeafUserDetailDraft extends LeafUserDetail, Draft {
    LeafUserDetailDraft.Producer $ = Producer.INSTANCE;

    @OldChain
    LeafUserDetailDraft setUserDetailId(long userDetailId);

    @OldChain
    LeafUserDetailDraft setFirstName(String firstName);

    @OldChain
    LeafUserDetailDraft setLastName(String lastName);

    @OldChain
    LeafUserDetailDraft setEthnic(String ethnic);

    @OldChain
    LeafUserDetailDraft setGender(String gender);

    @OldChain
    LeafUserDetailDraft setAge(Integer age);

    @OldChain
    LeafUserDetailDraft setAddress(String address);

    @OldChain
    LeafUserDetailDraft setHometown(String hometown);

    @OldChain
    LeafUserDetailDraft setIdCard(String idCard);

    List<LeafUserDraft> users(boolean autoCreate);

    @OldChain
    LeafUserDetailDraft setUsers(List<LeafUser> users);

    @OldChain
    LeafUserDetailDraft addIntoUsers(DraftConsumer<LeafUserDraft> block);

    @OldChain
    LeafUserDetailDraft addIntoUsers(LeafUser base, DraftConsumer<LeafUserDraft> block);

    class Producer {
        static final Producer INSTANCE = new Producer();

        public static final int SLOT_USER_DETAIL_ID = 0;

        public static final int SLOT_FIRST_NAME = 1;

        public static final int SLOT_LAST_NAME = 2;

        public static final int SLOT_ETHNIC = 3;

        public static final int SLOT_GENDER = 4;

        public static final int SLOT_AGE = 5;

        public static final int SLOT_ADDRESS = 6;

        public static final int SLOT_HOMETOWN = 7;

        public static final int SLOT_ID_CARD = 8;

        public static final int SLOT_USERS = 9;

        public static final ImmutableType TYPE = ImmutableType
            .newBuilder(
                "0.8.125",
                LeafUserDetail.class,
                Collections.emptyList(),
                (ctx, base) -> new DraftImpl(ctx, (LeafUserDetail)base)
            )
            .id(SLOT_USER_DETAIL_ID, "userDetailId", long.class)
            .key(SLOT_FIRST_NAME, "firstName", String.class, false)
            .key(SLOT_LAST_NAME, "lastName", String.class, false)
            .add(SLOT_ETHNIC, "ethnic", ImmutablePropCategory.SCALAR, String.class, true)
            .add(SLOT_GENDER, "gender", ImmutablePropCategory.SCALAR, String.class, true)
            .add(SLOT_AGE, "age", ImmutablePropCategory.SCALAR, Integer.class, true)
            .add(SLOT_ADDRESS, "address", ImmutablePropCategory.SCALAR, String.class, true)
            .add(SLOT_HOMETOWN, "hometown", ImmutablePropCategory.SCALAR, String.class, true)
            .add(SLOT_ID_CARD, "idCard", ImmutablePropCategory.SCALAR, String.class, true)
            .add(SLOT_USERS, "users", OneToMany.class, LeafUser.class, false)
            .build();

        private Producer() {
        }

        public LeafUserDetail produce(DraftConsumer<LeafUserDetailDraft> block) {
            return produce(null, block);
        }

        public LeafUserDetail produce(LeafUserDetail base,
                DraftConsumer<LeafUserDetailDraft> block) {
            return (LeafUserDetail)Internal.produce(TYPE, base, block);
        }

        @JsonPropertyOrder({"dummyPropForJacksonError__", "userDetailId", "firstName", "lastName", "ethnic", "gender", "age", "address", "hometown", "idCard", "users"})
        public abstract interface Implementor extends LeafUserDetail, ImmutableSpi {
            @Override
            default Object __get(PropId prop) {
                int __propIndex = prop.asIndex();
                switch (__propIndex) {
                    case -1:
                    		return __get(prop.asName());
                    case SLOT_USER_DETAIL_ID:
                    		return (Long)userDetailId();
                    case SLOT_FIRST_NAME:
                    		return firstName();
                    case SLOT_LAST_NAME:
                    		return lastName();
                    case SLOT_ETHNIC:
                    		return ethnic();
                    case SLOT_GENDER:
                    		return gender();
                    case SLOT_AGE:
                    		return age();
                    case SLOT_ADDRESS:
                    		return address();
                    case SLOT_HOMETOWN:
                    		return hometown();
                    case SLOT_ID_CARD:
                    		return idCard();
                    case SLOT_USERS:
                    		return users();
                    default: throw new IllegalArgumentException("Illegal property name for \"com.leaf.domain.LeafUserDetail\": \"" + prop + "\"");
                }
            }

            @Override
            default Object __get(String prop) {
                switch (prop) {
                    case "userDetailId":
                    		return (Long)userDetailId();
                    case "firstName":
                    		return firstName();
                    case "lastName":
                    		return lastName();
                    case "ethnic":
                    		return ethnic();
                    case "gender":
                    		return gender();
                    case "age":
                    		return age();
                    case "address":
                    		return address();
                    case "hometown":
                    		return hometown();
                    case "idCard":
                    		return idCard();
                    case "users":
                    		return users();
                    default: throw new IllegalArgumentException("Illegal property name for \"com.leaf.domain.LeafUserDetail\": \"" + prop + "\"");
                }
            }

            default long getUserDetailId() {
                return userDetailId();
            }

            default String getFirstName() {
                return firstName();
            }

            default String getLastName() {
                return lastName();
            }

            @Nullable
            default String getEthnic() {
                return ethnic();
            }

            @Nullable
            default String getGender() {
                return gender();
            }

            @Nullable
            default Integer getAge() {
                return age();
            }

            @Nullable
            default String getAddress() {
                return address();
            }

            @Nullable
            default String getHometown() {
                return hometown();
            }

            @Nullable
            default String getIdCard() {
                return idCard();
            }

            default List<LeafUser> getUsers() {
                return users();
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

            long __userDetailIdValue;

            boolean __userDetailIdLoaded = false;

            String __firstNameValue;

            String __lastNameValue;

            String __ethnicValue;

            boolean __ethnicLoaded = false;

            String __genderValue;

            boolean __genderLoaded = false;

            Integer __ageValue;

            boolean __ageLoaded = false;

            String __addressValue;

            boolean __addressLoaded = false;

            String __hometownValue;

            boolean __hometownLoaded = false;

            String __idCardValue;

            boolean __idCardLoaded = false;

            NonSharedList<LeafUser> __usersValue;

            @Override
            @JsonIgnore
            public long userDetailId() {
                if (!__userDetailIdLoaded) {
                    throw new UnloadedException(LeafUserDetail.class, "userDetailId");
                }
                return __userDetailIdValue;
            }

            @Override
            @JsonIgnore
            public String firstName() {
                if (__firstNameValue == null) {
                    throw new UnloadedException(LeafUserDetail.class, "firstName");
                }
                return __firstNameValue;
            }

            @Override
            @JsonIgnore
            public String lastName() {
                if (__lastNameValue == null) {
                    throw new UnloadedException(LeafUserDetail.class, "lastName");
                }
                return __lastNameValue;
            }

            @Override
            @JsonIgnore
            @Nullable
            public String ethnic() {
                if (!__ethnicLoaded) {
                    throw new UnloadedException(LeafUserDetail.class, "ethnic");
                }
                return __ethnicValue;
            }

            @Override
            @JsonIgnore
            @Nullable
            public String gender() {
                if (!__genderLoaded) {
                    throw new UnloadedException(LeafUserDetail.class, "gender");
                }
                return __genderValue;
            }

            @Override
            @JsonIgnore
            @Nullable
            public Integer age() {
                if (!__ageLoaded) {
                    throw new UnloadedException(LeafUserDetail.class, "age");
                }
                return __ageValue;
            }

            @Override
            @JsonIgnore
            @Nullable
            public String address() {
                if (!__addressLoaded) {
                    throw new UnloadedException(LeafUserDetail.class, "address");
                }
                return __addressValue;
            }

            @Override
            @JsonIgnore
            @Nullable
            public String hometown() {
                if (!__hometownLoaded) {
                    throw new UnloadedException(LeafUserDetail.class, "hometown");
                }
                return __hometownValue;
            }

            @Override
            @JsonIgnore
            @Nullable
            public String idCard() {
                if (!__idCardLoaded) {
                    throw new UnloadedException(LeafUserDetail.class, "idCard");
                }
                return __idCardValue;
            }

            @Override
            @JsonIgnore
            public List<LeafUser> users() {
                if (__usersValue == null) {
                    throw new UnloadedException(LeafUserDetail.class, "users");
                }
                return __usersValue;
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
                    case SLOT_USER_DETAIL_ID:
                    		return __userDetailIdLoaded;
                    case SLOT_FIRST_NAME:
                    		return __firstNameValue != null;
                    case SLOT_LAST_NAME:
                    		return __lastNameValue != null;
                    case SLOT_ETHNIC:
                    		return __ethnicLoaded;
                    case SLOT_GENDER:
                    		return __genderLoaded;
                    case SLOT_AGE:
                    		return __ageLoaded;
                    case SLOT_ADDRESS:
                    		return __addressLoaded;
                    case SLOT_HOMETOWN:
                    		return __hometownLoaded;
                    case SLOT_ID_CARD:
                    		return __idCardLoaded;
                    case SLOT_USERS:
                    		return __usersValue != null;
                    default: throw new IllegalArgumentException("Illegal property name for \"com.leaf.domain.LeafUserDetail\": \"" + prop + "\"");
                }
            }

            @Override
            public boolean __isLoaded(String prop) {
                switch (prop) {
                    case "userDetailId":
                    		return __userDetailIdLoaded;
                    case "firstName":
                    		return __firstNameValue != null;
                    case "lastName":
                    		return __lastNameValue != null;
                    case "ethnic":
                    		return __ethnicLoaded;
                    case "gender":
                    		return __genderLoaded;
                    case "age":
                    		return __ageLoaded;
                    case "address":
                    		return __addressLoaded;
                    case "hometown":
                    		return __hometownLoaded;
                    case "idCard":
                    		return __idCardLoaded;
                    case "users":
                    		return __usersValue != null;
                    default: throw new IllegalArgumentException("Illegal property name for \"com.leaf.domain.LeafUserDetail\": \"" + prop + "\"");
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
                    case SLOT_USER_DETAIL_ID:
                    		return __visibility.visible(SLOT_USER_DETAIL_ID);
                    case SLOT_FIRST_NAME:
                    		return __visibility.visible(SLOT_FIRST_NAME);
                    case SLOT_LAST_NAME:
                    		return __visibility.visible(SLOT_LAST_NAME);
                    case SLOT_ETHNIC:
                    		return __visibility.visible(SLOT_ETHNIC);
                    case SLOT_GENDER:
                    		return __visibility.visible(SLOT_GENDER);
                    case SLOT_AGE:
                    		return __visibility.visible(SLOT_AGE);
                    case SLOT_ADDRESS:
                    		return __visibility.visible(SLOT_ADDRESS);
                    case SLOT_HOMETOWN:
                    		return __visibility.visible(SLOT_HOMETOWN);
                    case SLOT_ID_CARD:
                    		return __visibility.visible(SLOT_ID_CARD);
                    case SLOT_USERS:
                    		return __visibility.visible(SLOT_USERS);
                    default: return true;
                }
            }

            @Override
            public boolean __isVisible(String prop) {
                if (__visibility == null) {
                    return true;
                }
                switch (prop) {
                    case "userDetailId":
                    		return __visibility.visible(SLOT_USER_DETAIL_ID);
                    case "firstName":
                    		return __visibility.visible(SLOT_FIRST_NAME);
                    case "lastName":
                    		return __visibility.visible(SLOT_LAST_NAME);
                    case "ethnic":
                    		return __visibility.visible(SLOT_ETHNIC);
                    case "gender":
                    		return __visibility.visible(SLOT_GENDER);
                    case "age":
                    		return __visibility.visible(SLOT_AGE);
                    case "address":
                    		return __visibility.visible(SLOT_ADDRESS);
                    case "hometown":
                    		return __visibility.visible(SLOT_HOMETOWN);
                    case "idCard":
                    		return __visibility.visible(SLOT_ID_CARD);
                    case "users":
                    		return __visibility.visible(SLOT_USERS);
                    default: return true;
                }
            }

            @Override
            public int hashCode() {
                int hash = __visibility != null ? __visibility.hashCode() : 0;
                if (__userDetailIdLoaded) {
                    hash = 31 * hash + Long.hashCode(__userDetailIdValue);
                    // If entity-id is loaded, return directly
                    return hash;
                }
                if (__firstNameValue != null) {
                    hash = 31 * hash + __firstNameValue.hashCode();
                }
                if (__lastNameValue != null) {
                    hash = 31 * hash + __lastNameValue.hashCode();
                }
                if (__ethnicLoaded && __ethnicValue != null) {
                    hash = 31 * hash + __ethnicValue.hashCode();
                }
                if (__genderLoaded && __genderValue != null) {
                    hash = 31 * hash + __genderValue.hashCode();
                }
                if (__ageLoaded && __ageValue != null) {
                    hash = 31 * hash + __ageValue.hashCode();
                }
                if (__addressLoaded && __addressValue != null) {
                    hash = 31 * hash + __addressValue.hashCode();
                }
                if (__hometownLoaded && __hometownValue != null) {
                    hash = 31 * hash + __hometownValue.hashCode();
                }
                if (__idCardLoaded && __idCardValue != null) {
                    hash = 31 * hash + __idCardValue.hashCode();
                }
                if (__usersValue != null) {
                    hash = 31 * hash + __usersValue.hashCode();
                }
                return hash;
            }

            private int __shallowHashCode() {
                int hash = __visibility != null ? __visibility.hashCode() : 0;
                if (__userDetailIdLoaded) {
                    hash = 31 * hash + Long.hashCode(__userDetailIdValue);
                }
                if (__firstNameValue != null) {
                    hash = 31 * hash + System.identityHashCode(__firstNameValue);
                }
                if (__lastNameValue != null) {
                    hash = 31 * hash + System.identityHashCode(__lastNameValue);
                }
                if (__ethnicLoaded) {
                    hash = 31 * hash + System.identityHashCode(__ethnicValue);
                }
                if (__genderLoaded) {
                    hash = 31 * hash + System.identityHashCode(__genderValue);
                }
                if (__ageLoaded) {
                    hash = 31 * hash + System.identityHashCode(__ageValue);
                }
                if (__addressLoaded) {
                    hash = 31 * hash + System.identityHashCode(__addressValue);
                }
                if (__hometownLoaded) {
                    hash = 31 * hash + System.identityHashCode(__hometownValue);
                }
                if (__idCardLoaded) {
                    hash = 31 * hash + System.identityHashCode(__idCardValue);
                }
                if (__usersValue != null) {
                    hash = 31 * hash + System.identityHashCode(__usersValue);
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
                if (__isVisible(PropId.byIndex(SLOT_USER_DETAIL_ID)) != __other.__isVisible(PropId.byIndex(SLOT_USER_DETAIL_ID))) {
                    return false;
                }
                boolean __userDetailIdLoaded = this.__userDetailIdLoaded;
                if (__userDetailIdLoaded != __other.__isLoaded(PropId.byIndex(SLOT_USER_DETAIL_ID))) {
                    return false;
                }
                if (__userDetailIdLoaded) {
                    // If entity-id is loaded, return directly
                    return __userDetailIdValue == __other.userDetailId();
                }
                if (__isVisible(PropId.byIndex(SLOT_FIRST_NAME)) != __other.__isVisible(PropId.byIndex(SLOT_FIRST_NAME))) {
                    return false;
                }
                boolean __firstNameLoaded = __firstNameValue != null;
                if (__firstNameLoaded != __other.__isLoaded(PropId.byIndex(SLOT_FIRST_NAME))) {
                    return false;
                }
                if (__firstNameLoaded && !Objects.equals(__firstNameValue, __other.firstName())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_LAST_NAME)) != __other.__isVisible(PropId.byIndex(SLOT_LAST_NAME))) {
                    return false;
                }
                boolean __lastNameLoaded = __lastNameValue != null;
                if (__lastNameLoaded != __other.__isLoaded(PropId.byIndex(SLOT_LAST_NAME))) {
                    return false;
                }
                if (__lastNameLoaded && !Objects.equals(__lastNameValue, __other.lastName())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_ETHNIC)) != __other.__isVisible(PropId.byIndex(SLOT_ETHNIC))) {
                    return false;
                }
                boolean __ethnicLoaded = this.__ethnicLoaded;
                if (__ethnicLoaded != __other.__isLoaded(PropId.byIndex(SLOT_ETHNIC))) {
                    return false;
                }
                if (__ethnicLoaded && !Objects.equals(__ethnicValue, __other.ethnic())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_GENDER)) != __other.__isVisible(PropId.byIndex(SLOT_GENDER))) {
                    return false;
                }
                boolean __genderLoaded = this.__genderLoaded;
                if (__genderLoaded != __other.__isLoaded(PropId.byIndex(SLOT_GENDER))) {
                    return false;
                }
                if (__genderLoaded && !Objects.equals(__genderValue, __other.gender())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_AGE)) != __other.__isVisible(PropId.byIndex(SLOT_AGE))) {
                    return false;
                }
                boolean __ageLoaded = this.__ageLoaded;
                if (__ageLoaded != __other.__isLoaded(PropId.byIndex(SLOT_AGE))) {
                    return false;
                }
                if (__ageLoaded && !Objects.equals(__ageValue, __other.age())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_ADDRESS)) != __other.__isVisible(PropId.byIndex(SLOT_ADDRESS))) {
                    return false;
                }
                boolean __addressLoaded = this.__addressLoaded;
                if (__addressLoaded != __other.__isLoaded(PropId.byIndex(SLOT_ADDRESS))) {
                    return false;
                }
                if (__addressLoaded && !Objects.equals(__addressValue, __other.address())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_HOMETOWN)) != __other.__isVisible(PropId.byIndex(SLOT_HOMETOWN))) {
                    return false;
                }
                boolean __hometownLoaded = this.__hometownLoaded;
                if (__hometownLoaded != __other.__isLoaded(PropId.byIndex(SLOT_HOMETOWN))) {
                    return false;
                }
                if (__hometownLoaded && !Objects.equals(__hometownValue, __other.hometown())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_ID_CARD)) != __other.__isVisible(PropId.byIndex(SLOT_ID_CARD))) {
                    return false;
                }
                boolean __idCardLoaded = this.__idCardLoaded;
                if (__idCardLoaded != __other.__isLoaded(PropId.byIndex(SLOT_ID_CARD))) {
                    return false;
                }
                if (__idCardLoaded && !Objects.equals(__idCardValue, __other.idCard())) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_USERS)) != __other.__isVisible(PropId.byIndex(SLOT_USERS))) {
                    return false;
                }
                boolean __usersLoaded = __usersValue != null;
                if (__usersLoaded != __other.__isLoaded(PropId.byIndex(SLOT_USERS))) {
                    return false;
                }
                if (__usersLoaded && !Objects.equals(__usersValue, __other.users())) {
                    return false;
                }
                return true;
            }

            private boolean __shallowEquals(Object obj) {
                if (obj == null || !(obj instanceof Implementor)) {
                    return false;
                }
                Implementor __other = (Implementor)obj;
                if (__isVisible(PropId.byIndex(SLOT_USER_DETAIL_ID)) != __other.__isVisible(PropId.byIndex(SLOT_USER_DETAIL_ID))) {
                    return false;
                }
                boolean __userDetailIdLoaded = this.__userDetailIdLoaded;
                if (__userDetailIdLoaded != __other.__isLoaded(PropId.byIndex(SLOT_USER_DETAIL_ID))) {
                    return false;
                }
                if (__userDetailIdLoaded && __userDetailIdValue != __other.userDetailId()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_FIRST_NAME)) != __other.__isVisible(PropId.byIndex(SLOT_FIRST_NAME))) {
                    return false;
                }
                boolean __firstNameLoaded = __firstNameValue != null;
                if (__firstNameLoaded != __other.__isLoaded(PropId.byIndex(SLOT_FIRST_NAME))) {
                    return false;
                }
                if (__firstNameLoaded && __firstNameValue != __other.firstName()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_LAST_NAME)) != __other.__isVisible(PropId.byIndex(SLOT_LAST_NAME))) {
                    return false;
                }
                boolean __lastNameLoaded = __lastNameValue != null;
                if (__lastNameLoaded != __other.__isLoaded(PropId.byIndex(SLOT_LAST_NAME))) {
                    return false;
                }
                if (__lastNameLoaded && __lastNameValue != __other.lastName()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_ETHNIC)) != __other.__isVisible(PropId.byIndex(SLOT_ETHNIC))) {
                    return false;
                }
                boolean __ethnicLoaded = this.__ethnicLoaded;
                if (__ethnicLoaded != __other.__isLoaded(PropId.byIndex(SLOT_ETHNIC))) {
                    return false;
                }
                if (__ethnicLoaded && __ethnicValue != __other.ethnic()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_GENDER)) != __other.__isVisible(PropId.byIndex(SLOT_GENDER))) {
                    return false;
                }
                boolean __genderLoaded = this.__genderLoaded;
                if (__genderLoaded != __other.__isLoaded(PropId.byIndex(SLOT_GENDER))) {
                    return false;
                }
                if (__genderLoaded && __genderValue != __other.gender()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_AGE)) != __other.__isVisible(PropId.byIndex(SLOT_AGE))) {
                    return false;
                }
                boolean __ageLoaded = this.__ageLoaded;
                if (__ageLoaded != __other.__isLoaded(PropId.byIndex(SLOT_AGE))) {
                    return false;
                }
                if (__ageLoaded && __ageValue != __other.age()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_ADDRESS)) != __other.__isVisible(PropId.byIndex(SLOT_ADDRESS))) {
                    return false;
                }
                boolean __addressLoaded = this.__addressLoaded;
                if (__addressLoaded != __other.__isLoaded(PropId.byIndex(SLOT_ADDRESS))) {
                    return false;
                }
                if (__addressLoaded && __addressValue != __other.address()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_HOMETOWN)) != __other.__isVisible(PropId.byIndex(SLOT_HOMETOWN))) {
                    return false;
                }
                boolean __hometownLoaded = this.__hometownLoaded;
                if (__hometownLoaded != __other.__isLoaded(PropId.byIndex(SLOT_HOMETOWN))) {
                    return false;
                }
                if (__hometownLoaded && __hometownValue != __other.hometown()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_ID_CARD)) != __other.__isVisible(PropId.byIndex(SLOT_ID_CARD))) {
                    return false;
                }
                boolean __idCardLoaded = this.__idCardLoaded;
                if (__idCardLoaded != __other.__isLoaded(PropId.byIndex(SLOT_ID_CARD))) {
                    return false;
                }
                if (__idCardLoaded && __idCardValue != __other.idCard()) {
                    return false;
                }
                if (__isVisible(PropId.byIndex(SLOT_USERS)) != __other.__isVisible(PropId.byIndex(SLOT_USERS))) {
                    return false;
                }
                boolean __usersLoaded = __usersValue != null;
                if (__usersLoaded != __other.__isLoaded(PropId.byIndex(SLOT_USERS))) {
                    return false;
                }
                if (__usersLoaded && __usersValue != __other.users()) {
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

        private static class DraftImpl implements Implementor, DraftSpi, LeafUserDetailDraft {
            private DraftContext __ctx;

            private Impl __base;

            private Impl __modified;

            private boolean __resolving;

            DraftImpl(DraftContext ctx, LeafUserDetail base) {
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
            public long userDetailId() {
                return (__modified!= null ? __modified : __base).userDetailId();
            }

            @Override
            public LeafUserDetailDraft setUserDetailId(long userDetailId) {
                Impl __tmpModified = __modified();
                __tmpModified.__userDetailIdValue = userDetailId;
                __tmpModified.__userDetailIdLoaded = true;
                return this;
            }

            @Override
            @JsonIgnore
            public String firstName() {
                return (__modified!= null ? __modified : __base).firstName();
            }

            @Override
            public LeafUserDetailDraft setFirstName(String firstName) {
                if (firstName == null) {
                    throw new IllegalArgumentException(
                        "'firstName' cannot be null, please specify non-null value or use nullable annotation to decorate this property"
                    );
                }
                Impl __tmpModified = __modified();
                __tmpModified.__firstNameValue = firstName;
                return this;
            }

            @Override
            @JsonIgnore
            public String lastName() {
                return (__modified!= null ? __modified : __base).lastName();
            }

            @Override
            public LeafUserDetailDraft setLastName(String lastName) {
                if (lastName == null) {
                    throw new IllegalArgumentException(
                        "'lastName' cannot be null, please specify non-null value or use nullable annotation to decorate this property"
                    );
                }
                Impl __tmpModified = __modified();
                __tmpModified.__lastNameValue = lastName;
                return this;
            }

            @Override
            @JsonIgnore
            @Nullable
            public String ethnic() {
                return (__modified!= null ? __modified : __base).ethnic();
            }

            @Override
            public LeafUserDetailDraft setEthnic(String ethnic) {
                Impl __tmpModified = __modified();
                __tmpModified.__ethnicValue = ethnic;
                __tmpModified.__ethnicLoaded = true;
                return this;
            }

            @Override
            @JsonIgnore
            @Nullable
            public String gender() {
                return (__modified!= null ? __modified : __base).gender();
            }

            @Override
            public LeafUserDetailDraft setGender(String gender) {
                Impl __tmpModified = __modified();
                __tmpModified.__genderValue = gender;
                __tmpModified.__genderLoaded = true;
                return this;
            }

            @Override
            @JsonIgnore
            @Nullable
            public Integer age() {
                return (__modified!= null ? __modified : __base).age();
            }

            @Override
            public LeafUserDetailDraft setAge(Integer age) {
                Impl __tmpModified = __modified();
                __tmpModified.__ageValue = age;
                __tmpModified.__ageLoaded = true;
                return this;
            }

            @Override
            @JsonIgnore
            @Nullable
            public String address() {
                return (__modified!= null ? __modified : __base).address();
            }

            @Override
            public LeafUserDetailDraft setAddress(String address) {
                Impl __tmpModified = __modified();
                __tmpModified.__addressValue = address;
                __tmpModified.__addressLoaded = true;
                return this;
            }

            @Override
            @JsonIgnore
            @Nullable
            public String hometown() {
                return (__modified!= null ? __modified : __base).hometown();
            }

            @Override
            public LeafUserDetailDraft setHometown(String hometown) {
                Impl __tmpModified = __modified();
                __tmpModified.__hometownValue = hometown;
                __tmpModified.__hometownLoaded = true;
                return this;
            }

            @Override
            @JsonIgnore
            @Nullable
            public String idCard() {
                return (__modified!= null ? __modified : __base).idCard();
            }

            @Override
            public LeafUserDetailDraft setIdCard(String idCard) {
                Impl __tmpModified = __modified();
                __tmpModified.__idCardValue = idCard;
                __tmpModified.__idCardLoaded = true;
                return this;
            }

            @Override
            @JsonIgnore
            public List<LeafUser> users() {
                return __ctx.toDraftList((__modified!= null ? __modified : __base).users(), LeafUser.class, true);
            }

            @Override
            public List<LeafUserDraft> users(boolean autoCreate) {
                if (autoCreate && (!__isLoaded(PropId.byIndex(SLOT_USERS)))) {
                    setUsers(new ArrayList<>());
                }
                return __ctx.toDraftList((__modified!= null ? __modified : __base).users(), LeafUser.class, true);
            }

            @Override
            public LeafUserDetailDraft setUsers(List<LeafUser> users) {
                if (users == null) {
                    throw new IllegalArgumentException(
                        "'users' cannot be null, please specify non-null value or use nullable annotation to decorate this property"
                    );
                }
                Impl __tmpModified = __modified();
                __tmpModified.__usersValue = NonSharedList.of(__tmpModified.__usersValue, users);
                return this;
            }

            @Override
            public LeafUserDetailDraft addIntoUsers(DraftConsumer<LeafUserDraft> block) {
                addIntoUsers(null, block);
                return this;
            }

            @Override
            public LeafUserDetailDraft addIntoUsers(LeafUser base,
                    DraftConsumer<LeafUserDraft> block) {
                users(true).add((LeafUserDraft)LeafUserDraft.$.produce(base, block));
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
                    case SLOT_USER_DETAIL_ID:
                    		if (value == null) throw new IllegalArgumentException("'userDetailId' cannot be null, if you want to set null, please use any annotation whose simple name is \"Nullable\" to decorate the property");
                            setUserDetailId((Long)value);
                            break;
                    case SLOT_FIRST_NAME:
                    		setFirstName((String)value);break;
                    case SLOT_LAST_NAME:
                    		setLastName((String)value);break;
                    case SLOT_ETHNIC:
                    		setEthnic((String)value);break;
                    case SLOT_GENDER:
                    		setGender((String)value);break;
                    case SLOT_AGE:
                    		setAge((Integer)value);break;
                    case SLOT_ADDRESS:
                    		setAddress((String)value);break;
                    case SLOT_HOMETOWN:
                    		setHometown((String)value);break;
                    case SLOT_ID_CARD:
                    		setIdCard((String)value);break;
                    case SLOT_USERS:
                    		setUsers((List<LeafUser>)value);break;
                    default: throw new IllegalArgumentException("Illegal property id for \"com.leaf.domain.LeafUserDetail\": \"" + prop + "\"");
                }
            }

            @SuppressWarnings("unchecked")
            @Override
            public void __set(String prop, Object value) {
                switch (prop) {
                    case "userDetailId":
                    		if (value == null) throw new IllegalArgumentException("'userDetailId' cannot be null, if you want to set null, please use any annotation whose simple name is \"Nullable\" to decorate the property");
                            setUserDetailId((Long)value);
                            break;
                    case "firstName":
                    		setFirstName((String)value);break;
                    case "lastName":
                    		setLastName((String)value);break;
                    case "ethnic":
                    		setEthnic((String)value);break;
                    case "gender":
                    		setGender((String)value);break;
                    case "age":
                    		setAge((Integer)value);break;
                    case "address":
                    		setAddress((String)value);break;
                    case "hometown":
                    		setHometown((String)value);break;
                    case "idCard":
                    		setIdCard((String)value);break;
                    case "users":
                    		setUsers((List<LeafUser>)value);break;
                    default: throw new IllegalArgumentException("Illegal property name for \"com.leaf.domain.LeafUserDetail\": \"" + prop + "\"");
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
                    case SLOT_USER_DETAIL_ID:
                    		__visibility.show(SLOT_USER_DETAIL_ID, visible);break;
                    case SLOT_FIRST_NAME:
                    		__visibility.show(SLOT_FIRST_NAME, visible);break;
                    case SLOT_LAST_NAME:
                    		__visibility.show(SLOT_LAST_NAME, visible);break;
                    case SLOT_ETHNIC:
                    		__visibility.show(SLOT_ETHNIC, visible);break;
                    case SLOT_GENDER:
                    		__visibility.show(SLOT_GENDER, visible);break;
                    case SLOT_AGE:
                    		__visibility.show(SLOT_AGE, visible);break;
                    case SLOT_ADDRESS:
                    		__visibility.show(SLOT_ADDRESS, visible);break;
                    case SLOT_HOMETOWN:
                    		__visibility.show(SLOT_HOMETOWN, visible);break;
                    case SLOT_ID_CARD:
                    		__visibility.show(SLOT_ID_CARD, visible);break;
                    case SLOT_USERS:
                    		__visibility.show(SLOT_USERS, visible);break;
                    default: throw new IllegalArgumentException(
                                "Illegal property id for \"com.leaf.domain.LeafUserDetail\": \"" + 
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
                    case "userDetailId":
                    		__visibility.show(SLOT_USER_DETAIL_ID, visible);break;
                    case "firstName":
                    		__visibility.show(SLOT_FIRST_NAME, visible);break;
                    case "lastName":
                    		__visibility.show(SLOT_LAST_NAME, visible);break;
                    case "ethnic":
                    		__visibility.show(SLOT_ETHNIC, visible);break;
                    case "gender":
                    		__visibility.show(SLOT_GENDER, visible);break;
                    case "age":
                    		__visibility.show(SLOT_AGE, visible);break;
                    case "address":
                    		__visibility.show(SLOT_ADDRESS, visible);break;
                    case "hometown":
                    		__visibility.show(SLOT_HOMETOWN, visible);break;
                    case "idCard":
                    		__visibility.show(SLOT_ID_CARD, visible);break;
                    case "users":
                    		__visibility.show(SLOT_USERS, visible);break;
                    default: throw new IllegalArgumentException(
                                "Illegal property name for \"com.leaf.domain.LeafUserDetail\": \"" + 
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
                    case SLOT_USER_DETAIL_ID:
                    		__modified().__userDetailIdLoaded = false;break;
                    case SLOT_FIRST_NAME:
                    		__modified().__firstNameValue = null;break;
                    case SLOT_LAST_NAME:
                    		__modified().__lastNameValue = null;break;
                    case SLOT_ETHNIC:
                    		__modified().__ethnicLoaded = false;break;
                    case SLOT_GENDER:
                    		__modified().__genderLoaded = false;break;
                    case SLOT_AGE:
                    		__modified().__ageLoaded = false;break;
                    case SLOT_ADDRESS:
                    		__modified().__addressLoaded = false;break;
                    case SLOT_HOMETOWN:
                    		__modified().__hometownLoaded = false;break;
                    case SLOT_ID_CARD:
                    		__modified().__idCardLoaded = false;break;
                    case SLOT_USERS:
                    		__modified().__usersValue = null;break;
                    default: throw new IllegalArgumentException("Illegal property id for \"com.leaf.domain.LeafUserDetail\": \"" + prop + "\", it does not exist or its loaded state is not controllable");
                }
            }

            @Override
            public void __unload(String prop) {
                switch (prop) {
                    case "userDetailId":
                    		__modified().__userDetailIdLoaded = false;break;
                    case "firstName":
                    		__modified().__firstNameValue = null;break;
                    case "lastName":
                    		__modified().__lastNameValue = null;break;
                    case "ethnic":
                    		__modified().__ethnicLoaded = false;break;
                    case "gender":
                    		__modified().__genderLoaded = false;break;
                    case "age":
                    		__modified().__ageLoaded = false;break;
                    case "address":
                    		__modified().__addressLoaded = false;break;
                    case "hometown":
                    		__modified().__hometownLoaded = false;break;
                    case "idCard":
                    		__modified().__idCardLoaded = false;break;
                    case "users":
                    		__modified().__usersValue = null;break;
                    default: throw new IllegalArgumentException("Illegal property name for \"com.leaf.domain.LeafUserDetail\": \"" + prop + "\", it does not exist or its loaded state is not controllable");
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
                        if (base.__isLoaded(PropId.byIndex(SLOT_USERS))) {
                            List<LeafUser> oldValue = base.users();
                            List<LeafUser> newValue = __ctx.resolveList(oldValue);
                            if (oldValue != newValue) {
                                setUsers(newValue);
                            }
                        }
                        __tmpModified = __modified;
                    }
                    else {
                        __tmpModified.__usersValue = NonSharedList.of(__tmpModified.__usersValue, __ctx.resolveList(__tmpModified.__usersValue));
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

        public Builder userDetailId(Long userDetailId) {
            if (userDetailId != null) {
                __draft.setUserDetailId(userDetailId);
            }
            return this;
        }

        public Builder firstName(String firstName) {
            if (firstName != null) {
                __draft.setFirstName(firstName);
            }
            return this;
        }

        public Builder lastName(String lastName) {
            if (lastName != null) {
                __draft.setLastName(lastName);
            }
            return this;
        }

        @Nullable
        public Builder ethnic(String ethnic) {
            __draft.setEthnic(ethnic);
            return this;
        }

        @Nullable
        public Builder gender(String gender) {
            __draft.setGender(gender);
            return this;
        }

        @Nullable
        public Builder age(Integer age) {
            __draft.setAge(age);
            return this;
        }

        @Nullable
        public Builder address(String address) {
            __draft.setAddress(address);
            return this;
        }

        @Nullable
        public Builder hometown(String hometown) {
            __draft.setHometown(hometown);
            return this;
        }

        @Nullable
        public Builder idCard(String idCard) {
            __draft.setIdCard(idCard);
            return this;
        }

        public Builder users(List<LeafUser> users) {
            if (users != null) {
                __draft.setUsers(users);
            }
            return this;
        }

        public LeafUserDetail build() {
            return (LeafUserDetail)__draft.__modified();
        }
    }
}
