import React from "react";
import { Button, FlatList, ScrollView } from "react-native";
import TodoItem from "./todo-item";

class TodoList extends React.Component {

    state = {
        data: [
            { title: "Item 0", id: "0", value: "Todo Item 00" },
            { title: "Item 1", id: "1", value: "Todo Item 01" },
            { title: "Item 2", id: "2", value: "Todo Item 02" },
            { title: "Item 3", id: "3", value: "Todo Item 03" }
        ]
    };

    renderItem = ({ item }) => {
        return (
            <TodoItem title={item.title} value={item.value} id={item.id} onChangeText={this.onChangeText} />
        );
    }

    onPress = () => {
        const data = this.state.data;
        const newId = data.length;
        const title = `Item ${newId}`;
        data.push({ title, id: `${newId}`, value: "" });
        this.setState({ data });
    }

    onChangeText = (value, id) => {
        let data = this.state.data;
        data = data.map(item => {
            const _item = item;
            if (_item.id === id) {
                _item.value = value;
            }
            return _item;
        });
        this.setState({ data });
    }

    render() {
        return (
            <>
                <Button
                    onPress={this.onPress}
                    title="Adicionar item"
                    color="#000000"
                    accessibilityLabel="Adicionar item a lista."
                />

                <FlatList
                    data={this.state.data}
                    keyExtractor={item => item.id}
                    renderItem={this.renderItem}
                />
            </>
        );
    }
}

export default TodoList;