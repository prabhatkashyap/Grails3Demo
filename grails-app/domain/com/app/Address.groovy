package com.app

import grails.rest.Resource

@Resource(uri = '/address', readOnly = true, formats = ['json', 'xml'])
class Address {

    String streetAddress
    String city
    String state

    static belongsTo = [profile: Profile]
    static constraints = {
        streetAddress(nullable: false, blank: false)
        city(nullable: false, blank: false)
        state(nullable: false, blank: false)
    }
}
