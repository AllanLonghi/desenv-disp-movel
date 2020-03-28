
import React from 'react';
import { StatusBar } from 'react-native';
import TodoList from './components/todo-list';

const App = () => {
  return (
    <>
      <StatusBar barStyle="dark-content" />
      <TodoList></TodoList>
    </>
  );
};

export default App;
