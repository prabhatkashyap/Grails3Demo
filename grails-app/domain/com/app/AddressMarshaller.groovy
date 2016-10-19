package com.app

import grails.rest.Resource

@Resource(uri = '/addressMarshallers', readOnly = true, formats = ['json', 'xml'])
class AddressMarshaller {

    String streetAddress
    String city
    String state

    static belongsTo = [profile: ProfileMarshaller]
    static constraints = {
        streetAddress(nullable: false, blank: false)
        city(nullable: false, blank: false)
        state(nullable: false, blank: false)
    }

//    def toXML(xml){
//        xml.build{
//            id(id)
//            streetAddress(streetAddress)
//            city(city)
//            state(state)
//        }
//    }
}
