package com.example.homeworkandroid

import java.nio.file.attribute.AclEntry.Builder

class ComputerBuilder(val builder:Builder) {
fun hasOS() =builder.OS
fun hasMouse() =builder.mouse
fun hasKeyboard() =builder.keyboard
fun hasMonitor() =builder.monitor
fun howMuchRAM() =builder.RAM
fun howMuchSSD() =builder.RAM


    companion object Builder{

        var OS:Boolean=false
        var mouse:Boolean=false
        var keyboard:Boolean=false
        var monitor:Boolean=false
        var RAM:Int =0
        var SSD:Int =0

        fun setOS(OS:Boolean) =apply { this.OS = OS }
        fun setMouse(mouse:Boolean) =apply { this.mouse = mouse }
        fun setKeyboard(keyboard:Boolean) =apply { this.keyboard = keyboard }
        fun setMonitor(monitor:Boolean) =apply { this.monitor = monitor }
        fun setRAM(RAM:Int) =apply { this.RAM = RAM }
        fun setSSD(SSD:Int) =apply { this.SSD = SSD }


        fun build(): ComputerBuilder{

            return  ComputerBuilder(this)
        }

    }



}