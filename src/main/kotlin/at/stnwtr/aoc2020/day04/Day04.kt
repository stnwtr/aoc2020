package at.stnwtr.aoc2020.day04

import at.stnwtr.aoc2020.shared.Day
import java.nio.file.Files

enum class PassportField(val fieldName: String, val validator: (String?) -> Boolean) {
    BIRTH_YEAR("byr", {
        it?.length == 4 && it.toIntOrNull() ?: 0 in 1920..2002
    }),
    ISSUE_YEAR("iyr", {
        it?.length == 4 && it.toIntOrNull() ?: 0 in 2010..2020
    }),
    EXPIRATION_YEAR("eyr", {
        it?.length == 4 && it.toIntOrNull() ?: 0 in 2020..2030
    }),
    HEIGHT("hgt", {
        when (it?.substring(it.length - 2)) {
            "in" -> it.substring(0, it.length - 2).toIntOrNull() ?: 0 in 59..76
            "cm" -> it.substring(0, it.length - 2).toIntOrNull() ?: 0 in 150..193
            else -> false
        }
    }),
    HAIR_COLOR("hcl", {
        it?.matches(Regex("#[a-f0-9]{6}")) ?: false
    }),
    EYE_COLOR("ecl", {
        it in arrayOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")
    }),
    PASSPORT_ID("pid", {
        it?.length == 9 && it.toIntOrNull() != null
    }),
    COUNTRY_ID("cid", {
        true
    });
}

class Passport(raw: String) {
    private val keyValueFields = raw.split(' ')
        .map { it.split(':') }

    private val birthYear = getField(PassportField.BIRTH_YEAR)
    private val issueYear = getField(PassportField.ISSUE_YEAR)
    private val expirationYear = getField(PassportField.EXPIRATION_YEAR)
    private val height = getField(PassportField.HEIGHT)
    private val hairColor = getField(PassportField.HAIR_COLOR)
    private val eyeColor = getField(PassportField.EYE_COLOR)
    private val passportId = getField(PassportField.PASSPORT_ID)
    private val countryId = getField(PassportField.COUNTRY_ID)

    private fun getField(field: PassportField) = keyValueFields.firstOrNull { it[0] == field.fieldName }?.get(1)

    fun isValidWithoutChecks(): Boolean {
        return birthYear != null && issueYear != null && expirationYear != null && height != null &&
                hairColor != null && eyeColor != null && passportId != null
    }

    fun isValidWithChecks(): Boolean {
        return PassportField.BIRTH_YEAR.validator(birthYear) && PassportField.ISSUE_YEAR.validator(issueYear) &&
                PassportField.EXPIRATION_YEAR.validator(expirationYear) && PassportField.HEIGHT.validator(height) &&
                PassportField.HAIR_COLOR.validator(hairColor) && PassportField.EYE_COLOR.validator(eyeColor) &&
                PassportField.PASSPORT_ID.validator(passportId) && PassportField.COUNTRY_ID.validator(countryId)
    }
}

class Day04 : Day<Int, Int>("04") {
    private val passports = Files.readString(inputFilePath)
        .trimEnd()
        .split(System.lineSeparator() + System.lineSeparator())
        .map { it.replace(System.lineSeparator(), " ") }
        .map { Passport(it) }

    override fun first(): Int {
        return passports.filter { it.isValidWithoutChecks() }.size
    }

    override fun second(): Int {
        return passports.filter { it.isValidWithChecks() }.size
    }
}