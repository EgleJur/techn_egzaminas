import { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import "../css/List.css";


export function ArticleListPage(props) {

    const [articles, setArticles] = useState([]);
    const JSON_HEADERS = {
        "Content-Type": "application/json"
    }

    const fetchArticles = () => {
        fetch('api/v1/articles')
            .then(response => response.json())
            .then(jsonResponse => setArticles(jsonResponse));
    };


    useEffect(() => {
        fetchArticles();
    }, []);

    const deleteArticle = (id) => {
        fetch("api/v1/articles/" + id, {
            method: "DELETE",
            headers: JSON_HEADERS
        }).then(fetchArticles);
    };


    return (<div className="List">
        <h2>Articles</h2>
        <table>
            <thead>
                <tr>
                <th></th>
                    <th>Pavadinimas</th>
                    <th>Tekstas</th>
                    <th>Sukūrimo data</th>
                    <th>Veiksmai</th>
                    <th></th>
                </tr>
            </thead>
        
        <tbody>
            {articles.map(article => (
                <tr key={article.id}>
                   
                   <td>{article.id}</td>
                    <td>{article.name}</td>
                    <td>{article.description}</td>
                    <td>{article.createdDate}</td>
                    <td><button onClick={() => deleteArticle(article.id)}>Delete</button></td>
                    <td><Link to={"/articles/view/" + article.id}>
                    <button>Skaityti</button></Link></td>
                </tr>
            ))}
        </tbody>
        </table>
    </div>
    )
}