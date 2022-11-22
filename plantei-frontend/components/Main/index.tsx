import styled from "styled-components";

class MainProps {
  backgroundColor: string;
  padding: string;
  children: React.ReactNode;
}

const MainStyled = styled.main<MainProps>`
  background: ${props => props.backgroundColor};
  padding: ${props => props.padding}rem;
  width: 100%;
  height: 100vh;
  margin: 0;
`;

export default function Main({
  backgroundColor,
  padding,
  children
}: MainProps) {
  
  return (
    <MainStyled
      backgroundColor={backgroundColor}
      padding={padding}
    >
      {children}
    </MainStyled>
  );
}