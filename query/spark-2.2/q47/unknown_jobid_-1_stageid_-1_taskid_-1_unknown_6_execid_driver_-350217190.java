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
/* 021 */     project_result = new UnsafeRow(8);
/* 022 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 128);
/* 023 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 8);
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
/* 037 */       UTF8String inputadapter_value3 = inputadapter_isNull3 ? null : (inputadapter_row.getUTF8String(3));
/* 038 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 039 */       int inputadapter_value4 = inputadapter_isNull4 ? -1 : (inputadapter_row.getInt(4));
/* 040 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 041 */       int inputadapter_value5 = inputadapter_isNull5 ? -1 : (inputadapter_row.getInt(5));
/* 042 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 043 */       double inputadapter_value6 = inputadapter_isNull6 ? -1.0 : (inputadapter_row.getDouble(6));
/* 044 */       boolean inputadapter_isNull8 = inputadapter_row.isNullAt(8);
/* 045 */       double inputadapter_value8 = inputadapter_isNull8 ? -1.0 : (inputadapter_row.getDouble(8));
/* 046 */       project_holder.reset();
/* 047 */
/* 048 */       project_rowWriter.zeroOutNullBytes();
/* 049 */
/* 050 */       if (inputadapter_isNull) {
/* 051 */         project_rowWriter.setNullAt(0);
/* 052 */       } else {
/* 053 */         project_rowWriter.write(0, inputadapter_value);
/* 054 */       }
/* 055 */
/* 056 */       if (inputadapter_isNull1) {
/* 057 */         project_rowWriter.setNullAt(1);
/* 058 */       } else {
/* 059 */         project_rowWriter.write(1, inputadapter_value1);
/* 060 */       }
/* 061 */
/* 062 */       if (inputadapter_isNull2) {
/* 063 */         project_rowWriter.setNullAt(2);
/* 064 */       } else {
/* 065 */         project_rowWriter.write(2, inputadapter_value2);
/* 066 */       }
/* 067 */
/* 068 */       if (inputadapter_isNull3) {
/* 069 */         project_rowWriter.setNullAt(3);
/* 070 */       } else {
/* 071 */         project_rowWriter.write(3, inputadapter_value3);
/* 072 */       }
/* 073 */
/* 074 */       if (inputadapter_isNull4) {
/* 075 */         project_rowWriter.setNullAt(4);
/* 076 */       } else {
/* 077 */         project_rowWriter.write(4, inputadapter_value4);
/* 078 */       }
/* 079 */
/* 080 */       if (inputadapter_isNull5) {
/* 081 */         project_rowWriter.setNullAt(5);
/* 082 */       } else {
/* 083 */         project_rowWriter.write(5, inputadapter_value5);
/* 084 */       }
/* 085 */
/* 086 */       if (inputadapter_isNull6) {
/* 087 */         project_rowWriter.setNullAt(6);
/* 088 */       } else {
/* 089 */         project_rowWriter.write(6, inputadapter_value6);
/* 090 */       }
/* 091 */
/* 092 */       if (inputadapter_isNull8) {
/* 093 */         project_rowWriter.setNullAt(7);
/* 094 */       } else {
/* 095 */         project_rowWriter.write(7, inputadapter_value8);
/* 096 */       }
/* 097 */       project_result.setTotalSize(project_holder.totalSize());
/* 098 */       append(project_result);
/* 099 */       if (shouldStop()) return;
/* 100 */     }
/* 101 */   }
/* 102 */ }
