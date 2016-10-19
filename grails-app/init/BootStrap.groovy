import com.app.Address
import com.app.AddressMarshaller
import com.app.Profile
import com.app.ProfileMarshaller
import grails.converters.JSON
import grails.converters.XML
import org.grails.web.converters.marshaller.xml.InstanceMethodBasedMarshaller

class BootStrap {

    def init = { servletContext ->
        Profile p1 = Profile.findOrSaveByFullNameAndMobileNo('Prabhat Kashyap', '1111111111')
        Profile p2 = Profile.findOrSaveByFullNameAndMobileNo('Ritesh Kumar', '2222222222')
        Profile p3 = Profile.findOrSaveByFullNameAndMobileNo('Nupur Dhawan', '3333333333')

        Address.findOrSaveByStreetAddressAndCityAndStateAndProfile("Street Address 11", "City 11", "State 11", p1)
        Address.findOrSaveByStreetAddressAndCityAndStateAndProfile("Street Address 12", "City 12", "State 12", p1)
        Address.findOrSaveByStreetAddressAndCityAndStateAndProfile("Street Address 13", "City 13", "State 13", p1)
        Address.findOrSaveByStreetAddressAndCityAndStateAndProfile("Street Address 14", "City 14", "State 14", p1)

        Address.findOrSaveByStreetAddressAndCityAndStateAndProfile("Street Address 21", "City 21", "State 21", p2)
        Address.findOrSaveByStreetAddressAndCityAndStateAndProfile("Street Address 22", "City 22", "State 22", p2)
        Address.findOrSaveByStreetAddressAndCityAndStateAndProfile("Street Address 23", "City 23", "State 23", p2)
        Address.findOrSaveByStreetAddressAndCityAndStateAndProfile("Street Address 24", "City 24", "State 24", p2)

        Address.findOrSaveByStreetAddressAndCityAndStateAndProfile("Street Address 31", "City 31", "State 31", p3)
        Address.findOrSaveByStreetAddressAndCityAndStateAndProfile("Street Address 32", "City 32", "State 32", p3)
        Address.findOrSaveByStreetAddressAndCityAndStateAndProfile("Street Address 33", "City 33", "State 33", p3)
        Address.findOrSaveByStreetAddressAndCityAndStateAndProfile("Street Address 34", "City 34", "State 34", p3)


        ProfileMarshaller p11 = ProfileMarshaller.findOrSaveByFullNameAndMobileNo('Prabhat Kashyap Marshaller', '1111111111')
        ProfileMarshaller p21 = ProfileMarshaller.findOrSaveByFullNameAndMobileNo('Ritesh Kumar Marshaller', '2222222222')
        ProfileMarshaller p31 = ProfileMarshaller.findOrSaveByFullNameAndMobileNo('Nupur Dhawan Marshaller', '3333333333')

        AddressMarshaller.findOrSaveByStreetAddressAndCityAndStateAndProfile("Street Address 11 Marshaller", "City 11 Marshaller", "State 11 Marshaller", p11)
        AddressMarshaller.findOrSaveByStreetAddressAndCityAndStateAndProfile("Street Address 12 Marshaller", "City 12 Marshaller", "State 12 Marshaller", p11)
        AddressMarshaller.findOrSaveByStreetAddressAndCityAndStateAndProfile("Street Address 13 Marshaller", "City 13 Marshaller", "State 13 Marshaller", p11)
        AddressMarshaller.findOrSaveByStreetAddressAndCityAndStateAndProfile("Street Address 14 Marshaller", "City 14 Marshaller", "State 14 Marshaller", p11)

        AddressMarshaller.findOrSaveByStreetAddressAndCityAndStateAndProfile("Street Address 21 Marshaller", "City 21 Marshaller", "State 21 Marshaller", p21)
        AddressMarshaller.findOrSaveByStreetAddressAndCityAndStateAndProfile("Street Address 22 Marshaller", "City 22 Marshaller", "State 22 Marshaller", p21)
        AddressMarshaller.findOrSaveByStreetAddressAndCityAndStateAndProfile("Street Address 23 Marshaller", "City 23 Marshaller", "State 23 Marshaller", p21)
        AddressMarshaller.findOrSaveByStreetAddressAndCityAndStateAndProfile("Street Address 24 Marshaller", "City 24 Marshaller", "State 24 Marshaller", p21)

        AddressMarshaller.findOrSaveByStreetAddressAndCityAndStateAndProfile("Street Address 31 Marshaller", "City 31 Marshaller", "State 31 Marshaller", p31)
        AddressMarshaller.findOrSaveByStreetAddressAndCityAndStateAndProfile("Street Address 32 Marshaller", "City 32 Marshaller", "State 32 Marshaller", p31)
        AddressMarshaller.findOrSaveByStreetAddressAndCityAndStateAndProfile("Street Address 33 Marshaller", "City 33 Marshaller", "State 33 Marshaller", p31)
        AddressMarshaller.findOrSaveByStreetAddressAndCityAndStateAndProfile("Street Address 34 Marshaller", "City 34 Marshaller", "State 34 Marshaller", p31)

        println("////////////////Started Marshalling//////")
        JSON.registerObjectMarshaller(ProfileMarshaller) {
            def returnArray = [:]
            returnArray['fullName'] = it.fullName
            returnArray['mobileNo'] = it.mobileNo
            returnArray['addresses'] = it.addresses
            return returnArray
        }

        JSON.registerObjectMarshaller(AddressMarshaller) {
            def returnArray = [:]
            returnArray['id'] = it.id
            returnArray['streetAddress'] = it.streetAddress
            returnArray['city'] = it.city
            returnArray['state'] = it.state
            return returnArray
        }
        XML.registerObjectMarshaller(ProfileMarshaller) { ProfileMarshaller profileMarshaller, converter ->
            converter.build {
                id profileMarshaller?.id
                fullName profileMarshaller?.fullName
                mobileNo profileMarshaller?.mobileNo
                addresses([]) {
                    profileMarshaller?.addresses?.each { AddressMarshaller addressMarshaller ->
                        address([]) {
                            id addressMarshaller?.id
                        }
                    }
                }
            }

        }
        XML.registerObjectMarshaller(AddressMarshaller) { AddressMarshaller addressMarshaller, converter ->
            converter.build {
                id addressMarshaller?.id
            }
        }
//        XML.registerObjectMarshaller(new InstanceMethodBasedMarshaller())
        println("////" + AddressMarshaller.count())
        println("////" + AddressMarshaller.list()*.profile?.id)
        println("////////////////End Marshalling//////")

    }
    def destroy = {
    }
}
