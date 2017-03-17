#!/bin/bash

adb reverse tcp:8081 tcp:8081
adb reverse tcp:3449 tcp:3449
react-native run-android --variant debug
