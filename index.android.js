// import { AppRegistry } from 'react-native';
// import App from './App';

// AppRegistry.registerComponent('androidReactNative', () => App);
import React, { Component } from 'react';
import { AppRegistry, View } from 'react-native';

class FixedDimensionsBasics extends Component {
  render() {
      return (
          <View style={{ flex: 1, justifyContent: "center", alignItems: "center",color:"black"}}>
            <Text>Hello, world!</Text>
          </View>
      );
    }
  };
// 注册应用(registerComponent)后才能正确渲染
// 注意：只把应用作为一个整体注册一次，而不是每个组件/模块都注册
AppRegistry.registerComponent('AOPTest', () => FixedDimensionsBasics);