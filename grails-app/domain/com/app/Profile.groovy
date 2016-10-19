package com.app

import grails.rest.Resource

@Resource(uri = '/profiles', readOnly = true, formats = ['json', 'xml'])
class Profile {

    String fullName
    String mobileNo

    static hasMany = [addresses: Address]

    static constraints = {
        fullName(nullable: false, blank: false)
        mobileNo(nullable: false, blank: false)
    }
}
