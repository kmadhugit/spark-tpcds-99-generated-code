/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private scala.collection.Iterator inputadapter_input;
/* 009 */   private UnsafeRow project_result;
/* 010 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 011 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 012 */
/* 013 */   public GeneratedIterator(Object[] references) {
/* 014 */     this.references = references;
/* 015 */   }
/* 016 */
/* 017 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 018 */     partitionIndex = index;
/* 019 */     this.inputs = inputs;
/* 020 */     inputadapter_input = inputs[0];
/* 021 */     project_result = new UnsafeRow(7);
/* 022 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 96);
/* 023 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 7);
/* 024 */
/* 025 */   }
/* 026 */
/* 027 */   protected void processNext() throws java.io.IOException {
/* 028 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 029 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 030 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 031 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 032 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 033 */       UTF8String inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getUTF8String(1));
/* 034 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 035 */       UTF8String inputadapter_value2 = inputadapter_isNull2 ? null : (inputadapter_row.getUTF8String(2));
/* 036 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 037 */       int inputadapter_value3 = inputadapter_isNull3 ? -1 : (inputadapter_row.getInt(3));
/* 038 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 039 */       int inputadapter_value4 = inputadapter_isNull4 ? -1 : (inputadapter_row.getInt(4));
/* 040 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 041 */       double inputadapter_value5 = inputadapter_isNull5 ? -1.0 : (inputadapter_row.getDouble(5));
/* 042 */       boolean inputadapter_isNull7 = inputadapter_row.isNullAt(7);
/* 043 */       double inputadapter_value7 = inputadapter_isNull7 ? -1.0 : (inputadapter_row.getDouble(7));
/* 044 */       project_holder.reset();
/* 045 */
/* 046 */       project_rowWriter.zeroOutNullBytes();
/* 047 */
/* 048 */       if (inputadapter_isNull) {
/* 049 */         project_rowWriter.setNullAt(0);
/* 050 */       } else {
/* 051 */         project_rowWriter.write(0, inputadapter_value);
/* 052 */       }
/* 053 */
/* 054 */       if (inputadapter_isNull1) {
/* 055 */         project_rowWriter.setNullAt(1);
/* 056 */       } else {
/* 057 */         project_rowWriter.write(1, inputadapter_value1);
/* 058 */       }
/* 059 */
/* 060 */       if (inputadapter_isNull2) {
/* 061 */         project_rowWriter.setNullAt(2);
/* 062 */       } else {
/* 063 */         project_rowWriter.write(2, inputadapter_value2);
/* 064 */       }
/* 065 */
/* 066 */       if (inputadapter_isNull3) {
/* 067 */         project_rowWriter.setNullAt(3);
/* 068 */       } else {
/* 069 */         project_rowWriter.write(3, inputadapter_value3);
/* 070 */       }
/* 071 */
/* 072 */       if (inputadapter_isNull4) {
/* 073 */         project_rowWriter.setNullAt(4);
/* 074 */       } else {
/* 075 */         project_rowWriter.write(4, inputadapter_value4);
/* 076 */       }
/* 077 */
/* 078 */       if (inputadapter_isNull5) {
/* 079 */         project_rowWriter.setNullAt(5);
/* 080 */       } else {
/* 081 */         project_rowWriter.write(5, inputadapter_value5);
/* 082 */       }
/* 083 */
/* 084 */       if (inputadapter_isNull7) {
/* 085 */         project_rowWriter.setNullAt(6);
/* 086 */       } else {
/* 087 */         project_rowWriter.write(6, inputadapter_value7);
/* 088 */       }
/* 089 */       project_result.setTotalSize(project_holder.totalSize());
/* 090 */       append(project_result);
/* 091 */       if (shouldStop()) return;
/* 092 */     }
/* 093 */   }
/* 094 */ }
