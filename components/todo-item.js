import React from 'react';
import { StyleSheet, Text, TextInput, View } from 'react-native';

export default class TodoItem extends React.Component {
    render() {
        const { value, title, onChangeText, id } = this.props;
        return (
            <View style={styles.item}>
                <Text style={styles.title}>{title}</Text>
                <TextInput
                    style={styles.text}
                    onChangeText={text => onChangeText(text, id)}
                    value={value}
                />
            </View>
        );
    }

}

const styles = StyleSheet.create({
    item: {
        alignItems: "center",
        backgroundColor: "#4480d4",
        flexGrow: 1,
        margin: 4,
        padding: 20
    },
    text: {
        fontSize: 15,
        color: "#333333"
    },
    title: {
        fontSize: 14,
        color: "#000000",
        fontWeight : "bold"
    }
});
