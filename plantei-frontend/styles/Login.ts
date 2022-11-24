import styled from "styled-components";

export const LoginHeader = styled.header`
  display: grid;
  justify-content: center;
  padding: 3rem 0 1rem 0;

  & > h1 {
    color: #217B51;
    font-weight: 300;
    font-size: 20px;
  }
`;

export const SubmitDiv = styled.div`
  display: grid;
  justify-content: center;
`;

export const LoginFooter = styled.footer`
  display: flex;
  justify-content: center;
  color: #7B7878;
  font-weight: 300;
  padding-top: 3rem;

  p {
    line-height: 1.5rem;
    width: 55%;
    text-align: center;
  }

  a {
    color: #8AC561;
  }
`;