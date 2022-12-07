import { useForm, SubmitHandler } from "react-hook-form";
import Link from "next/link";
import Image from "next/image";

import Main from "../../components/Main";

import { CardSelect, Content, ContentForm, ContentFormSM, DivCards, NovaPlantaHeader, NovaPlantaText, SubmitDiv } from "../../styles/NovaPlanta";
import Input from "../../components/Input";
import Button from "../../components/Button";
import { useRouter } from "next/router";
import BottomMenu from "../../components/BottomMenu";

type Inputs = {
  nome: string,
  sobrenome: string,
  email: string,
  senha: string,
};

export default function Step3(props) {
  const {
    register,
    handleSubmit,
    watch,
    formState: { errors }
  } = useForm<Inputs>();
  
  const onSubmit: SubmitHandler<Inputs> = data => console.log(data);
  const router = useRouter();
  console.log(watch("email"), errors)
  
  return (
    <Main backgroundColor="#FFFFFF" padding="2">
        <NovaPlantaHeader>
          <h2>Selecione sua nova <span>planta</span></h2>
          <h3>Confira o que temos para você:</h3>
        </NovaPlantaHeader>
          <ContentFormSM onSubmit={handleSubmit(onSubmit)}>
            <Content className="contentsm">
            <div>
              <DivCards>
                <CardSelect>
                  <Image src="/tipo-planta/alface.png" alt="Alface" width={95} height={95} />
                  <p>Alface</p>
                </CardSelect>
                <CardSelect>
                  <Image src="/tipo-planta/pepino.png" alt="Pepino" width={95} height={95} />
                  <p>Pepino</p>
                </CardSelect>
                <CardSelect>
                  <Image src="/tipo-planta/morango.png" alt="Morango" width={95} height={95} />
                  <p>Morango</p>
                </CardSelect>
            </DivCards>
            <DivCards>
                <CardSelect>
                  <Image src="/tipo-planta/rabanete.png" alt="Rabanete" width={95} height={95} />
                  <p>Rabanete</p>
                </CardSelect>
                <CardSelect>
                  <Image src="/tipo-planta/manjericao.png" alt="Manjericão" width={95} height={95} />
                  <p>Manjericão</p>
                </CardSelect>
                <CardSelect>
                  <Image src="/tipo-planta/alho.png" alt="Alho" width={95} height={95} />
                  <p>Alho</p>
                </CardSelect>
              </DivCards>
            </div>
            
            <SubmitDiv className="contentsm">
              <Button
                backgroundColor="#217B51"
                width="min-content"
                color="#FFF"
                padding="15px 100px"
                fontSize="18px"
                onClick={() => router.push('/NovaPlanta/step-4')}
              >
                Continuar
              </Button>
            </SubmitDiv>
            <BottomMenu backgroundColor="#FFF"></BottomMenu>
            </Content>
          </ContentFormSM>
    </Main>
  );
}
  