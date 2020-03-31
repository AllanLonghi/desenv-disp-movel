import React from "react";
import { Button, FlatList } from "react-native";
import TodoItem from "./todo-item";

class TodoList extends React.Component {

    state = {
        data: [ ]
    };

    renderItem = ({ item }) => {
        return (
            <TodoItem title={item.title} value={item.value} id={item.id} onChangeText={this.onChangeText} close={this.close} />
        );
    }

    close = (id) => {
        const filteredData = this.state.data.filter(item => item.id !== id);
        this.setState({ data: filteredData });
    }

    onPress = () => {
        const data = this.state.data;
        const newId = (data.length > 0 ? parseInt(data[data.length-1].id) : 0) + 1;
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
                    scrollEnabled={false}
                />
            </>
        );
    }

}

export default TodoList;