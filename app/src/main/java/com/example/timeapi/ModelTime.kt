package com.example.timeapi

data class ModelTime(
    var abbreviation: String,
    var client_ip: String,
    var datetime: String,
    var day_of_week: Int,
    var day_of_year: Int,
    var dst: Boolean,
    var dst_from: Any,
    var dst_offset: Int,
    var dst_until: Any,
    var raw_offset: Int,
    var timezone: String,
    var unixtime: Int,
    var utc_datetime: String,
    var utc_offset: String,
    var week_number: Int
)