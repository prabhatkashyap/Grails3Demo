package com.app

import grails.rest.Resource

@Resource(uri = '/profileMarshallers', readOnly = true, formats = ['json', 'xml'])
class ProfileMarshaller {

    String fullName
    String mobileNo

    static hasMany = [addresses: AddressMarshaller]

    static constraints = {
        fullName(nullable: false, blank: false)
        mobileNo(nullable: false, blank: false)
    }

//    def toXML(xml){
//        xml.build{
//            id(id)
//            fullName(fullName)
//            mobileNo(mobileNo)
//        }
//    }
}
