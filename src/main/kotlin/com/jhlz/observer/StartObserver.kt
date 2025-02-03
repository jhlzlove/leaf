package com.jhlz.observer

import io.quarkus.runtime.StartupEvent
import jakarta.enterprise.event.Observes

/**
 * @author jhlz
 * @version x.x.x
 */
class StartObserver {
    fun onStart(@Observes ev: StartupEvent) {
        println("潮水啊 我已归来")
    }
}