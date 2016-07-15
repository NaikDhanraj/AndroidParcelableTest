# AndroidParcelableTest

1)Passing parcelable object in intent 
 -implement parcelable interface to the object
 -now make an object parcelable , implement two methods defined in Parcelable interface
 .describeContents()
 .writeToParcel(Parcel dest, int flags)
 -we have to provide Parcelable.Creator that is used to create an instance of the class from the Parcel data.
 -in the writeToParcel method we simply write all the class attributes
 -in the Parcel.Creator we read the parcel data.
 -creator calls a constructor passing Parcel object and here in the constructor we initialise the class attributes.
