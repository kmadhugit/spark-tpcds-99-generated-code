/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private scala.collection.Iterator inputadapter_input;
/* 009 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 010 */   private UnsafeRow filter_result;
/* 011 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 012 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 013 */
/* 014 */   public GeneratedIterator(Object[] references) {
/* 015 */     this.references = references;
/* 016 */   }
/* 017 */
/* 018 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 019 */     partitionIndex = index;
/* 020 */     this.inputs = inputs;
/* 021 */     inputadapter_input = inputs[0];
/* 022 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 023 */     filter_result = new UnsafeRow(6);
/* 024 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 32);
/* 025 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 6);
/* 026 */
/* 027 */   }
/* 028 */
/* 029 */   protected void processNext() throws java.io.IOException {
/* 030 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 031 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 032 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 033 */       double inputadapter_value4 = inputadapter_isNull4 ? -1.0 : (inputadapter_row.getDouble(4));
/* 034 */
/* 035 */       if (!(!(inputadapter_isNull4))) continue;
/* 036 */
/* 037 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 038 */       double inputadapter_value5 = inputadapter_isNull5 ? -1.0 : (inputadapter_row.getDouble(5));
/* 039 */
/* 040 */       if (!(!(inputadapter_isNull5))) continue;
/* 041 */
/* 042 */       boolean filter_isNull4 = false;
/* 043 */
/* 044 */       boolean filter_value4 = false;
/* 045 */       filter_value4 = org.apache.spark.util.Utils.nanSafeCompareDoubles(inputadapter_value4, inputadapter_value5) > 0;
/* 046 */       if (!filter_value4) continue;
/* 047 */
/* 048 */       filter_numOutputRows.add(1);
/* 049 */
/* 050 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 051 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 052 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 053 */       UTF8String inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getUTF8String(1));
/* 054 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 055 */       double inputadapter_value2 = inputadapter_isNull2 ? -1.0 : (inputadapter_row.getDouble(2));
/* 056 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 057 */       double inputadapter_value3 = inputadapter_isNull3 ? -1.0 : (inputadapter_row.getDouble(3));
/* 058 */       filter_holder.reset();
/* 059 */
/* 060 */       filter_rowWriter.zeroOutNullBytes();
/* 061 */
/* 062 */       if (inputadapter_isNull) {
/* 063 */         filter_rowWriter.setNullAt(0);
/* 064 */       } else {
/* 065 */         filter_rowWriter.write(0, inputadapter_value);
/* 066 */       }
/* 067 */
/* 068 */       if (inputadapter_isNull1) {
/* 069 */         filter_rowWriter.setNullAt(1);
/* 070 */       } else {
/* 071 */         filter_rowWriter.write(1, inputadapter_value1);
/* 072 */       }
/* 073 */
/* 074 */       if (inputadapter_isNull2) {
/* 075 */         filter_rowWriter.setNullAt(2);
/* 076 */       } else {
/* 077 */         filter_rowWriter.write(2, inputadapter_value2);
/* 078 */       }
/* 079 */
/* 080 */       if (inputadapter_isNull3) {
/* 081 */         filter_rowWriter.setNullAt(3);
/* 082 */       } else {
/* 083 */         filter_rowWriter.write(3, inputadapter_value3);
/* 084 */       }
/* 085 */
/* 086 */       filter_rowWriter.write(4, inputadapter_value4);
/* 087 */
/* 088 */       filter_rowWriter.write(5, inputadapter_value5);
/* 089 */       filter_result.setTotalSize(filter_holder.totalSize());
/* 090 */       append(filter_result);
/* 091 */       if (shouldStop()) return;
/* 092 */     }
/* 093 */   }
/* 094 */ }
