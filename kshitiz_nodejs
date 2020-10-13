const request = require('request')
//° N, 
const url = 'https://api.openweathermap.org/data/2.5/onecall?lat=20.5937&lon=&%20exclude=hourly,daily&appid=2a9f7d15a0ae6c691ec7095456bc3b02&units=metric&lang=en'


request({ url : url , json : true }, (error , response) => {
    if(error){
        console.log('Unable to connect with weather services !!')
    }
    else if(response.body.message) {
        console.log('Provide proper values !!')
    }
    else{
                console.log(response.body.daily[0].weather[0].description+'. It is currently '+ response.body.current.temp +' degrees out . There is '+ response.body.current.humidity +' humidity in weather')
    }
})







//  const geocodeurl = 'https://api.mapbox.com/geocoding/v5/mapbox.places/Los%20Angeles.json?access_token=pk.eyJ1Ijoia3NoaXRpemdvZWwwNyIsImEiOiJja2Q3c205am8wbjk3MndzY2kybmh4OTI2In0.gjcyvHJpPk0opg7mUFX0jA&limit=1'


//  request({ url : geocodeurl , json : true},(error , response) => {
//      const longitude = response.body.features[0].center[0]

//     const latitude = response.body.features[0].center[1]

//      console.log(latitude+','+ longitude)
//  })

