import axios from "axios";
import { useEffect, useState } from "react"

interface Employee {
  firstName: string,
  lastName: string,
  description: string,
  _links: {
    self: {
      href: string
    }
  }
}

export default function Employees() {
  const [error, setError] = useState<Error | null>(null);
  const [isLoaded, setIsLoaded] = useState(false);
  const [employees, setEmployees] = useState<Employee[]>([]);

  async function getEmployees() {
    try {
      const response = await axios.get("/api/employees");
      setIsLoaded(true);
      setEmployees(response.data._embedded.employees)

    } catch (error: any) {
      setIsLoaded(true);
      setError(error);
    }
  }

  useEffect(() => {
    getEmployees();
  }, [])

  if (error) {
    return <div>Error: {error.message}</div>
  } else if (!isLoaded) {
    return <div>Loading...</div>
  } else {
    return (
      <ul>
        {employees.map((employee) => (
          <li key={employee._links.self.href}>
            {employee.firstName}
          </li>
        ))}
      </ul>
    )
  }
}