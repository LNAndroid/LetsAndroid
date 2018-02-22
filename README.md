# LetsAndroid
### Branch : [Android](https://github.com/LNAndroid/LetsAndroid/tree/android)
Java Code Android examples:

#### 1) [Wikitude-Gesture](https://github.com/LNAndroid/LetsAndroid/tree/android/Wikitude-Gesture)

####Gestures

The Wikitude SDK supports a number of gestures, which allow you to interact with augmentations.

This example shows how to use three of those gestures in an AR scene to drag, rotate and scale images of glasses, beards and hats so they can be positioned on a face.
Target Images:- https://www.wikitude.com/external/doc/documentation/7.1/iosnative/targetimages.html

#### 2) [Wikitude-3DObject-Rendering](https://github.com/LNAndroid/LetsAndroid/tree/android/Wikitude-3DObject-Rendering)

3D Rendering

This example shows how to augment a target image with 3D content. It starts by displaying a 3D model on a target and advances by adding displayed animations, interactivity and demonstrates the snap-to-screen functionality. The last example shows how 3D content can be placed at a certain geographic location.

If you are not yet familiar with how to create a vision based augmented reality scene (based on image recognition and tracking), please have a look at the previous example Client Recognition.

3D content within Wikitude can only be loaded from Wikitude 3D Format files (.wt3). This is a compressed binary format for describing 3D content which is optimized for fast loading and handling of 3D content on a mobile device. You still can use 3D models from your favorite 3D modeling tools (Autodesk® Maya® or Blender) but you'll need to convert them into the wt3 file format. The Wikitude 3D Encoder desktop application (Windows and Mac) encodes your 3D source file. The Encoder can handle Autodesk® FBX® files (.fbx)for encoding to .wt3 .

For more details on how to convert your 3D content please see the Wikitude 3D Encoder section. In this example the .wt3 file has already been prepared and saved to assets/car.wt3.
