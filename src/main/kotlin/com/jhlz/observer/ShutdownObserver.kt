package com.jhlz.observer

import io.quarkus.runtime.ShutdownEvent
import jakarta.enterprise.event.Observes

/**
 * @author jhlz
 * @version x.x.x
 */
class ShutdownObserver {
    fun onShutdown(@Observes e: ShutdownEvent) {
        println("人生百年 吾道不孤")
    }
}