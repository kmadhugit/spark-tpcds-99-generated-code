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
/* 021 */     project_result = new UnsafeRow(2);
/* 022 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 32);
/* 023 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 2);
/* 024 */
/* 025 */   }
/* 026 */
/* 027 */   protected void processNext() throws java.io.IOException {
/* 028 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 029 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 030 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 031 */       InternalRow inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getStruct(0, 16));
/* 032 */
/* 033 */       boolean project_isNull = inputadapter_isNull;
/* 034 */       UTF8String project_value = null;
/* 035 */
/* 036 */       if (!inputadapter_isNull) {
/* 037 */         if (inputadapter_value.isNullAt(0)) {
/* 038 */           project_isNull = true;
/* 039 */         } else {
/* 040 */           project_value = inputadapter_value.getUTF8String(0);
/* 041 */         }
/* 042 */
/* 043 */       }
/* 044 */       boolean project_isNull2 = inputadapter_isNull;
/* 045 */       double project_value2 = -1.0;
/* 046 */
/* 047 */       if (!inputadapter_isNull) {
/* 048 */         if (inputadapter_value.isNullAt(9)) {
/* 049 */           project_isNull2 = true;
/* 050 */         } else {
/* 051 */           project_value2 = inputadapter_value.getDouble(9);
/* 052 */         }
/* 053 */
/* 054 */       }
/* 055 */       project_holder.reset();
/* 056 */
/* 057 */       project_rowWriter.zeroOutNullBytes();
/* 058 */
/* 059 */       if (project_isNull) {
/* 060 */         project_rowWriter.setNullAt(0);
/* 061 */       } else {
/* 062 */         project_rowWriter.write(0, project_value);
/* 063 */       }
/* 064 */
/* 065 */       if (project_isNull2) {
/* 066 */         project_rowWriter.setNullAt(1);
/* 067 */       } else {
/* 068 */         project_rowWriter.write(1, project_value2);
/* 069 */       }
/* 070 */       project_result.setTotalSize(project_holder.totalSize());
/* 071 */       append(project_result);
/* 072 */       if (shouldStop()) return;
/* 073 */     }
/* 074 */   }
/* 075 */ }
