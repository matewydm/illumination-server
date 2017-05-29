import ReactDOM from 'react-dom';
import React from 'react';
import { Button,ButtonToolbar } from 'react-bootstrap';




var EMPLOYEES = [
    {name: 'Joe11111111 Biden', age: 45, years: 5},
    {name: 'President11 Obama', age: 54, years: 8},
    {name: 'Cryst11al Mac', age: 34, years: 12    },
    {name: 'Jame11s Henry', age: 33, years: 2}
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


class App extends React.Component{
    render(){
        return(<div>
                <h1>{buttonsInstance}</h1>
                <div><EmployeeTable employees={EMPLOYEES} /></div>
            </div>

        )
    }
}
ReactDOM.render(<App/>
    , document.getElementById('root'));
