import { NavLink, NavLinkProps, useLocation } from "react-router-dom";

export default function QueryNavLink(props: NavLinkProps) {
  const location = useLocation();
  const newProps = { ...props, to: props.to + location.search };

  return <NavLink {...newProps} />
}