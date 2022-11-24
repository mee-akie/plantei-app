import { useForm, SubmitHandler } from "react-hook-form";
import Image from "../../node_modules/next/image";

import Input from "../../components/Input/index";
import Button from "../../components/Button/index";
import Main from "../../components/Main";

import { LoginFooter, LoginHeader, SubmitDiv } from "../../styles/Login";
import Link from "next/link";

type Inputs = {
  email: string,
  senha: string,
};

export default function Login(props) {
  const {
    register,
    handleSubmit,
    watch,
    formState: { errors }
  } = useForm<Inputs>();
  
  const onSubmit: SubmitHandler<Inputs> = data => console.log(data);
  
  console.log(watch("email"), errors)
  
  return (
    <Main backgroundColor="#E8F8E3" padding="1">
      <LoginHeader>
        <Image src="/icone_plantei.svg" alt="Ícone plantei" width={95} height={95} />
        <h1>Que bom te ter por aqui!</h1>
      </LoginHeader>
      
      <form onSubmit={handleSubmit(onSubmit)}>
        <Input
          {...register("email", { required: true })}
          placeholder="Email"
          border="1px solid #EDCA5C"
          width={100}
          margin="20px 0"
        />
        
        <Input
          {...register("senha", { required: true })}
          placeholder="Senha"
          type="password"
          border="1px solid #EDCA5C"
          width={100}
          margin="0 0 30px 0"
        />
        
        <SubmitDiv>
          <Button
            backgroundColor="#EDCA5C"
            width="min-content"
            color="#7B7878"
            padding="10px 35px"
          >
            Entrar
          </Button>
        </SubmitDiv>
      </form>

      <LoginFooter>
        <p>
          {/* TODO: trocar esses href pelas rotas certas */}
          <a href="https://www.w3schools.com/">Esqueceu a senha</a> ou ainda precisa de um <Link href="/Register">novo cadastro</Link>?
          Fica tranquilo!
        </p>
      </LoginFooter>
    </Main>
    );
  }
  