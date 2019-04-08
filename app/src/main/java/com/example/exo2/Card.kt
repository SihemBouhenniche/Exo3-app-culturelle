package com.example.exo2

class Card {
    var title:String?=null
    var des:String?=null
    var photo:Int?=null
    var rate:Float?=null

    constructor(title:String,des:String,photo:Int, rate:Float){
        this.des= des
        this.title = title
        this.photo = photo
        this.rate = rate
    }
}