package com.example.kalkulyator

fun main1(string: String): String {
    var string = string
    val count_percent=string.count{it=='%'}
    if (string.indexOf('%')>=0) {
        for (i in 0..count_percent){
            string= getPercent(string)
        }
    }
    var numbers = mutableListOf<Double>()
    val count_k = string.count { it == 'x' }
    val count_tobe = string.count { it == '/' }
    val count = count_k + count_tobe
    for (i in 0..count) {
        if (string.indexOf('x') >= 0 && string.indexOf('/') >= 0 && string.indexOf('x') < string.indexOf(
                '/'
            )
        ) {
            string = getReplace_k("x", string)
        } else if (string.indexOf('x') >= 0 && string.indexOf('/') >= 0 && string.indexOf('x') > string.indexOf(
                '/'
            )
        ) {
            string = getReplace_tobe("/", string)
        } else if (string.indexOf('x') >= 0 && string.indexOf('/') < 0) {
            string = getReplace_k("x", string)
        } else if (string.indexOf('x') < 0 && string.indexOf('/') >= 0) {
            string = getReplace_tobe("/", string)
        } else {
            string = string
        }
    }
    val count_plus = string.count { it == '+' }
    val count_minus = string.count { it == '-' }
    val count2 = (count_plus + count_minus) * 2
    for (i in 0..count2) {
        if (string.indexOf('+') >= 0 && string.indexOf('-') >= 0 && string.indexOf('+') < string.indexOf(
                '-'
            )
        ) {
            string = getReplace_plus("+", string)
        } else if (string.indexOf('+') >= 0 && string.indexOf('-') >= 0 && string.indexOf('+') > string.indexOf(
                '-'
            )
        ) {
            string = getReplace_ayirish("-", string, numbers)
        } else if (string.indexOf('+') >= 0 && string.indexOf('-') < 0) {
            string = getReplace_plus("+", string)
        } else if (string.indexOf('+') < 0 && string.indexOf('-') >= 0) {
            string = getReplace_ayirish("-", string, numbers)
        } else {
            string = string
        }
    }
    if (numbers.isEmpty().not()) {
        val sum = numbers.sum()
        string = (string.toDouble() - sum).toString()
        numbers.clear()
        return string
    }else{
    return string
    }
}

fun getReplace_k(char: String, string: String): String {
    var nextstring = ""
    var backstring = ""
    if (string.isEmpty()) {
        return string
    }
    if (string.count { it == 'x' } == 0) {
        return string
    }
    if (char in string) {
        var string = string
        var index = string.indexOf(char, 0)
        if (index == string.lastIndex) {
            string = string.dropLast(1)
            return string
        }

        index += 1
        while (string[index] != '+' && string[index] != '-' && string[index] != 'x' && string[index] != '/' && string[index] != '%') {
            nextstring += string[index]
            if (index == string.lastIndex) {
                break
            }
            index += 1
        }
        println(nextstring)
        index = string.indexOf('x')
        if (index == string.lastIndex) {
            string = string.dropLast(1)
        }
        if (index == 0) {
            string = string.drop(1)
            return string
        }
        index -= 1
        while (string[index] != '+' && string[index] != '-' && string[index] != 'x' && string[index] != '/' && string[index] != '%') {
            backstring += string[index]
            if (index == string.lastIndex) {
                break
            }
            if (index == 0) {
                break
            }
            index -= 1
        }
        backstring = backstring.reversed()
        println(backstring)
    }
    var value = backstring.toDouble() * nextstring.toDouble()
    val newstring = string.replace(backstring + "x" + nextstring, value.toString())
    return newstring
}

fun getReplace_tobe(char: String, string: String): String {
    var nextstring = ""
    var backstring = ""
    if (string.isEmpty()) {
        return string
    }
    if (string.count { it == '/' } == 0) {
        return string
    }
    if (char in string) {
        var string = string
        var index = string.indexOf(char, 0)
        if (index == string.lastIndex) {
            string = string.dropLast(1)
            return string
        }

        index += 1
        while (string[index] != '+' && string[index] != '-' && string[index] != 'x' && string[index] != '/' && string[index] != '%') {
            nextstring += string[index]
            if (index == string.lastIndex) {
                break
            }
            index += 1
        }
        println(nextstring)
        index = string.indexOf('/')
        if (index == string.lastIndex) {
            string = string.dropLast(1)
        }
        if (index == 0) {
            string = string.drop(1)
            return string
        }
        index -= 1
        while (string[index] != '+' && string[index] != '-' && string[index] != 'x' && string[index] != '/' && string[index] != '%') {
            backstring += string[index]
            if (index == string.lastIndex) {
                break
            }
            if (index == 0) {
                break
            }
            index -= 1
        }
        backstring = backstring.reversed()
        println(backstring)
    }
    var value = backstring.toDouble() / nextstring.toDouble()
    val newstring = string.replace(backstring + "/" + nextstring, value.toString())
    return newstring
}

fun getReplace_plus(char: String, string: String): String {
    var nextstring = ""
    var backstring = ""
    if (string.isEmpty()) {
        return string
    }
    if (string.count { it == '+' } == 0) {
        return string
    }
    if (char in string) {
        var string = string
        var index = string.indexOf(char, 0)
        if (index == string.lastIndex) {
            string = string.dropLast(1)
            return string
        }

        index += 1
        while (string[index] != '+' && string[index] != '-' && string[index] != 'x' && string[index] != '/' && string[index] != '%') {
            nextstring += string[index]
            if (index == string.lastIndex) {
                break
            }
            index += 1
        }
        println(nextstring)
        index = string.indexOf('+')
        if (index == string.lastIndex) {
            string = string.dropLast(1)
        }
        if (index == 0) {
            val zero = 0
            string = zero.toString() + string
            return string
        }
        index -= 1
        while (string[index] != '+' && string[index] != '-' && string[index] != 'x' && string[index] != '/' && string[index] != '%') {
            backstring += string[index]
            if (index == string.lastIndex) {
                break
            }
            if (index == 0) {
                break
            }
            index -= 1
        }
        backstring = backstring.reversed()
        println(backstring)
    }
    var value = backstring.toDouble() + nextstring.toDouble()
    val newstring = string.replace(backstring + "+" + nextstring, value.toString())
    return newstring
}

fun getReplace_ayirish(char: String, string: String, numbers: MutableList<Double>): String {
    var nextstring = ""
    var numbers = numbers
    if (string.isEmpty()) {
        return string
    }
    if (string.count { it == '-' } == 0) {
        return string
    }
    if (char in string) {
        var string = string
        var index = string.indexOf(char, 0)
        if (index == string.lastIndex) {
            string = string.dropLast(1)
            return string
        }

        index += 1
        while (string[index] != '+' && string[index] != '-' && string[index] != 'x' && string[index] != '/' && string[index] != '%') {
            nextstring += string[index]
            if (index == string.lastIndex) {
                break
            }
            index += 1
        }
        println(nextstring)
        numbers.add(nextstring.toDouble())
    }
    var newstring = string.replace(char + nextstring, "+" + (0).toString())
    return newstring
}

fun getPercent(string: String): String {
    var string = string
    var backstring = ""
    var result: Double? =null
    if ('%' in string) {
        var index = string.indexOf('%')
        if (index == 0) {
            string.drop(1)
            string = string
        } else {
            index-=1
            while (string[index] != '+' && string[index] != '-' && string[index] != 'x' && string[index] != '/') {
                backstring += string[index]
                if (index==0) {
                    break
                }
                index-=1
            }
            backstring=backstring.reversed()
            result=backstring.toDouble()/100
        }
        string=string.replace(backstring+'%',result.toString())
    }
    return string
}

