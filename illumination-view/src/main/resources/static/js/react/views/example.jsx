import ReactDOM from 'react-dom';
import React from 'react';
import { Button,ButtonToolbar } from 'react-bootstrap';

import { ReactRouter,Router, Route, Switch } from 'react-router';



var EMPLOYEES = [
    {name: 'Joe Biden', age: 45, years: 5},
    {name: 'President Obama', age: 54, years: 8},
    {name: 'Crystal Mac', age: 34, years: 12    },
    {name: 'James Henry', age: 33, years: 2}
];


var Employee = React.createClass({
    render: function() {
        return (
            <tr>
                <td>{this.props.employee.name}</td>
                <td>{this.props.employee.age}</td>
                <td>{this.props.employee.years}</td>
            </tr>);
    }
});

var EmployeeTable = React.createClass({
    render: function() {
        var rows = [];
        this.props.employees.forEach(function(employee) {
            rows.push(<Employee employee={employee} />);
        });
        return (
            <table>
                <thead>
                <tr>
                    <th>Name</th><th>Age</th><th>Years</th>
                </tr>
                </thead>
                <tbody>{rows}</tbody>
            </table>);
    }
});
{/*<EmployeeTable employees={EMPLOYEES} />*/}

const buttonsInstance = (
    <ButtonToolbar>
        {/* Standard button */}
        <Button>Default</Button>

        {/* Provides extra visual weight and identifies the primary action in a set of buttons */}
        <Button bsStyle="primary">Primary</Button>

        {/* Indicates a successful or positive action */}
        <Button bsStyle="success">Success</Button>

        {/* Contextual button for informational alert messages */}
        <Button bsStyle="info">Info</Button>

        {/* Indicates caution should be taken with this action */}
        <Button bsStyle="warning">Warning</Button>

        {/* Indicates a dangerous or potentially negative action */}
        <Button bsStyle="danger">Danger</Button>

        {/* Deemphasize a button by making it look like a link while maintaining button behavior */}
        <Button bsStyle="link">Link</Button>
    </ButtonToolbar>
);


class App2 extends React.Component{
    render(){
        return(<div>
                <h1>{buttonsInstance}</h1>
                <div><EmployeeTable employees={EMPLOYEES} /></div>
                </div>

        )
    }
}
var App = React.createClass({
    render: function() {
        return (
            <div>
                <h1>Simple SPA</h1>
                <ul className="header">
                    <li>Home</li>
                    <li>Stuff</li>
                    <li>Contact</li>
                </ul>
                <div className="content">

                </div>
            </div>
        )
    }
});
var Home = React.createClass({
    render: function() {
        return (<h1>Welcome to the Home Page</h1>);
    }
});
ReactDOM.render(  <Router>
        <Route path="/blank" component={Home} />
    </Router>
    , document.getElementById('root'));
