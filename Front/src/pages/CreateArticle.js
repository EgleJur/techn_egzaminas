import { useState } from "react"
import {useHref} from 'react-router-dom';


export function CreateArticlePage(props) {
    const [name, setName] = useState("");
    const [description, setDescription] = useState("");

    const listUrl = useHref('/');
    const clear = () =>{
        setName("");
        setDescription("");
    };

    const applyResult = (result) => {
        if (result.ok) {
            clear();
        }else{
            window.alert("Nepavyko sukursti: " + result.status);
        }
    };

    const createArticle = () => {
        fetch('/api/v1/articles', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                name,
                description,
                registered: false
            })
        }).then(applyResult)
        .then(() => window.location = listUrl);
    };


    return (
        <fieldset id="create">
            <legend>Create new article</legend>
            <div>
                <label htmlFor="name">Pavadinimas </label>
                <input
                    id="name"
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                />
            </div>
         
            <div>
                <label htmlFor="description">Description</label>
                <input
                    id="description"
                    value={description}
                    onChange={(e) => setDescription(e.target.value)} />
            </div>
            <div>
                <button onClick = {createArticle}>Create</button>
            </div>
        </fieldset>
    )
}