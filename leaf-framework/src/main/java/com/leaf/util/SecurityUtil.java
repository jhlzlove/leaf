// package com.leaf.common.util;
//
// import com.leaf.domain.LoginUser;
//
// /**
//  * Spring Security 工具类
//  *
//  * @author jhlz
//  * @version 1.0.0
//  */
// public class SecurityUtil {
//
//     /**
//      * 获取登录用户
//      *
//      * @return 登录用户
//      */
//     public static String getLoginUsername() {
//         return ((LoginUser) getAuthentication().getPrincipal()).getUsername();
//     }
//
//     public static Authentication getAuthentication() {
//         return SecurityContextHolder.getContext().getAuthentication();
//     }
//
//     /**
//      * 生成 BCryptPasswordEncoder 密码
//      *
//      * @param password 密码
//      * @return 加密字符串
//      */
//     public static String encryptPassword(final String password) {
//         BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//         return passwordEncoder.encode(password);
//     }
//
//     /**
//      * 判断密码是否相同
//      *
//      * @param rawPassword     真实密码
//      * @param encodedPassword 加密后字符
//      * @return 结果
//      */
//     public static boolean matchesPassword(final String rawPassword,
//                                           final String encodedPassword) {
//         BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//         return passwordEncoder.matches(rawPassword, encodedPassword);
//     }
//
//     /**
//      * 从当前线程中显式清除上下文值
//      */
//     public static void clear() {
//         SecurityContextHolder.clearContext();
//     }
// }
