import React from 'react';
import { Animated, PanResponder, StyleSheet, Text, TextInput, View, Dimensions } from 'react-native';

const {width} = Dimensions.get('window');

export default class TodoItem extends React.Component {

    constructor(props) {
        super(props);
        const position = new Animated.ValueXY();

        this.gestureDelay = -35;
        this.scrollViewEnabled = true;

        this.panResponder = PanResponder.create({
            onStartShouldSetPanResponder: (evt, gestureState) => false,
            onMoveShouldSetPanResponder: (evt, gestureState) => true,
            onPanResponderTerminationRequest: (evt, gestureState) => false,
            onPanResponderMove: (evt, gestureState) => {
                if (gestureState.dx > 35) {
                    //this.setScrollViewEnabled(false);
                    let newX = gestureState.dx + this.gestureDelay;
                    position.setValue({ x: newX, y: 0 });
                }
            },
            onPanResponderRelease: (evt, gestureState) => {
                if (gestureState.dx < 150) {
                    Animated.timing(this.state.position, {
                        toValue: { x: 0, y: 0 },
                        duration: 150,
                    }).start(() => {
                        //this.setScrollViewEnabled(true);
                    });

                } else {
                    Animated.timing(this.state.position, {
                        toValue: { x: width, y: 0 },
                        duration: 300,
                    }).start(() => {
                        this.props.close(this.props.id);
                        //.setScrollViewEnabled(true);
                    });
                }
            },
        });
        this.state = { position };
    }

    render() {
        const { value, title, onChangeText, id } = this.props;
        return (
            <View>
                <Animated.View style={[this.state.position.getLayout()]} {...this.panResponder.panHandlers}>
                    <View style={styles.item}>
                        <Text style={styles.title}>{title}</Text>
                        <TextInput
                            style={styles.text}
                            onChangeText={text => onChangeText(text, id)}
                            value={value} />
                    </View>
                </Animated.View>
            </View>
        );
    }

}

const styles = StyleSheet.create({
    item: {
        backgroundColor: "#4480d4",
        flexGrow: 1,
        margin: 4,
        padding: 20,
        alignItems: "center",
    },
    text: {
        fontSize: 15,
        color: "#333333"
    },
    title: {
        fontSize: 14,
        color: "#000000",
        fontWeight: "bold"
    },
    button: {
        position: 'absolute',
        right: 10,
        top: 100,
        fontWeight: "bold",
        color: "#a11e15"
    }
});
