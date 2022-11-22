import styled from "styled-components";

export const Container = styled.div`
  padding: 15px;
`;

export const FormGroup = styled.div`
  display: flex;
`;

export const RegisterHeader = styled.header`
  display: grid;
  justify-content: center;
  padding: 3rem 0 1rem 0;

  & > h1 {
    color: #217B51;
    font-weight: 400;
    font-size: 30px;
    text-align: center;
    margin-bottom: 0px;
  }

  & > h2 {
    color: #9AC979;
    font-weight: 400;
    font-size: 16px;
    text-align: center;
    margin-top: 0px;
  }

`;

export const SubmitDiv = styled.div`
  display: grid;
  justify-content: center;
`;

export const RegisterFooter = styled.div`
  align-self: flex-end;
  float: right;
`;