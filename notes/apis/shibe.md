# Api1

1.http://shibe.online/api/shibes?count=[1-100]&urls=[true/false]&httpsUrls=[true/false]
```
//参数
count,	integers 1-100,	The number of images to be returned. Default is 1.

urls,	true/false,	Should the API return URLs or filenames without extensions? URLs are the default.

httpsUrls,	true/false,	Should the URLs be HTTPS or HTTP? They're HTTPS by default now.


http://shibe.online/api/cats?count=[1-100]&urls=[true/false]&httpsUrls=[true/false]
http://shibe.online/api/birds?count=[1-100]&urls=[true/false]&httpsUrls=[true/false]
You can also get pictures of cats at /api/cats or birds at /api/birds. Same parameters apply.

http://shibe.online/api/shibes?count=10&urls=true&httpsUrls=true

[
"https://cdn.shibe.online/shibes/859c758fb6bfae4aa9f0412bae0633de8c6203ff.jpg",
"https://cdn.shibe.online/shibes/6f78d388883a094607731c62f4c2d47089ab6fea.jpg",
"https://cdn.shibe.online/shibes/ef37197846f287a654bc621c4e5d2ba70f0b3ab3.jpg",
"https://cdn.shibe.online/shibes/d21c549e5d240e953e1504df657b470d904a2b10.jpg",
"https://cdn.shibe.online/shibes/d539de64dfa45e1277eac70464d2eade2abdcea3.jpg",
"https://cdn.shibe.online/shibes/0a64520b959939fe307211d0354d4da20931b6af.jpg",
"https://cdn.shibe.online/shibes/3dc257eb1309db0f992b9bf2ba45d2216d7a10ff.jpg",
"https://cdn.shibe.online/shibes/138b983e60fa3d3b8a79e4a256f695c6e148f692.jpg",
"https://cdn.shibe.online/shibes/e09b5e3e4a7e0e4ca1a2d1cffe20e303b6b49cf9.jpg",
"https://cdn.shibe.online/shibes/4fb93402e986dfb2bc4ba01e475a7b5e8c0fe812.jpg"
]

http://shibe.online/api/birds?count=10&urls=true&httpsUrls=false

[
"http://cdn.shibe.online/birds/0a969cf320763fd594f77d8df1e933cf6c25e98c.jpg",
"http://cdn.shibe.online/birds/f5040fd34496e96c16aa3226595bcc7f8782b7e4.jpg",
"http://cdn.shibe.online/birds/1be4e2a29bfea578c0dd53cc8354f5bdeb255eb8.jpg",
"http://cdn.shibe.online/birds/b1c8d309a7fc944aae3966c443a24cbc65c8eecb.jpg",
"http://cdn.shibe.online/birds/cadf1984b3b2cc4090b96ea83dbf3ccb07c82cba.jpg",
"http://cdn.shibe.online/birds/fe336ecf1577f5ac38009903ddb58679e3abe179.jpg",
"http://cdn.shibe.online/birds/f346985ab0d5bc249c4ce47654785818e5572f37.jpg",
"http://cdn.shibe.online/birds/0cad4a0accda85397e1a228eed0cbc1da50b488c.jpg",
"http://cdn.shibe.online/birds/ea6a2a55b9e0cff96306fef93a54fede790fd42e.jpg",
"http://cdn.shibe.online/birds/9d784de65d41c2aa0922fc7a8f906b83e7e074bf.jpg"
]

//网站  https://shibe.online/


```
