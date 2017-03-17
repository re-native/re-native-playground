#!/bin/bash

cp ios/react-native-xcode.sh node_modules/react-native/packager/react-native-xcode.sh
cp ios/packager.sh node_modules/react-native/packager/packager.sh
re-natal use-ios-device simulator
re-natal use-figwheel
re-natal enable-source-maps
