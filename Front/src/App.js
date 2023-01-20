import { ArticleListPage } from './pages/ArticleList';
import './App.css';
import { useState } from 'react';
import { Menu } from './components/Menu'
import { CreateArticlePage } from './pages/CreateArticle';

import { ViewArticle } from './pages/ViewArticle';
import { HashRouter, Route, Routes } from 'react-router-dom';
import { CreateComment } from "./pages/CreateComment";

function App() {
 
  return (
    <div className="App">
      <HashRouter>
        <Menu />
        <Routes>
        <Route path='/' element={<ArticleListPage />} />
        <Route path='/create' element={<CreateArticlePage />} />
        <Route path='/createComment' element={<CreateComment />} />
        <Route path='/articles/view/:id' element={<ViewArticle />} />
        </Routes>
      </HashRouter>
    </div>
  );
}

export default App;
