import { useEffect, useState } from "react"
import { Container, Row, Col, Table, Button } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
const API_BASE_URL = import.meta.env.VITE_API_URL;


const Dashboard =()=>{
    const [employees, setEmployees] = useState([]);
    const navigate = useNavigate();

    useEffect( () => {
        const fetchEmployees = async () =>{
            try {
                const response = await fetch(`${API_BASE_URL}/api/employees`);
                const data = await response.json();

                setEmployees(data)
            } catch (error) {
                console.log("Error fetching employee", error.message);
            }
        }

        fetchEmployees();
    }, []);

    const handleDelete = async(employeeId) =>{
        try {
            const response = await fetch(`${API_BASE_URL}/api/employee/${employeeId}`, {
            method: "DELETE",
        });

        if(response.ok){
            setEmployees((prevEmployees) =>
            prevEmployees.filter((employee) => employee.id !== employeeId))
        }

            console.log(`Employee with id ${employeeId} is deleted successfully`);
            
        } catch (error) {
            console.log("Error deleteing employee", error.message);
        }
    }

    const handleUpdate = (employeeId) => {
        navigate(`/employee/${employeeId}`)
    }
 
    return(
       <>
       <Container className="mt-5"></Container>
            <Row>
                <Col>
                <h1 className="text-center">Employees</h1>
                <Table striped bordered hover responsive>
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Phone</th>
                            <th>Department</th>
                            <th>Action</th>
                        </tr>
                        
                    </thead>
                    <tbody>
                        {employees.map((employee) => (
                            <tr key={employee.id}>
                                <td>{employee.name}</td>
                                <td>{employee.email}</td>
                                <td>{employee.phone}</td>
                                <td>{employee.department}</td>
                                <td>
                                    <Button variant={"outline-secondary"} onClick={() => handleUpdate(employee.id)}>Update</Button>{" "}
                                    <Button variant={"outline-danger"} onClick={() => handleDelete(employee.id)}>Delete</Button>
                                </td>
                            </tr>
                        ))}

                    </tbody>
                </Table>
                </Col>
            </Row>
       </>
       
    );
}

export default Dashboard