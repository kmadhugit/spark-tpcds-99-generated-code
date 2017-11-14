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
/* 013 */   private UnsafeRow project_result;
/* 014 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 015 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 016 */
/* 017 */   public GeneratedIterator(Object[] references) {
/* 018 */     this.references = references;
/* 019 */   }
/* 020 */
/* 021 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 022 */     partitionIndex = index;
/* 023 */     this.inputs = inputs;
/* 024 */     inputadapter_input = inputs[0];
/* 025 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 026 */     filter_result = new UnsafeRow(5);
/* 027 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 64);
/* 028 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 5);
/* 029 */     project_result = new UnsafeRow(5);
/* 030 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 64);
/* 031 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 5);
/* 032 */
/* 033 */   }
/* 034 */
/* 035 */   protected void processNext() throws java.io.IOException {
/* 036 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 037 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 038 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 039 */       int inputadapter_value3 = inputadapter_isNull3 ? -1 : (inputadapter_row.getInt(3));
/* 040 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 041 */       int inputadapter_value4 = inputadapter_isNull4 ? -1 : (inputadapter_row.getInt(4));
/* 042 */
/* 043 */       boolean filter_isNull1 = true;
/* 044 */       boolean filter_value1 = false;
/* 045 */
/* 046 */       if (!inputadapter_isNull3) {
/* 047 */         filter_isNull1 = false; // resultCode could change nullability.
/* 048 */         filter_value1 = inputadapter_value3 <= 10;
/* 049 */
/* 050 */       }
/* 051 */       boolean filter_isNull = false;
/* 052 */       boolean filter_value = true;
/* 053 */
/* 054 */       if (!filter_isNull1 && filter_value1) {
/* 055 */       } else {
/* 056 */         boolean filter_isNull4 = true;
/* 057 */         boolean filter_value4 = false;
/* 058 */
/* 059 */         if (!inputadapter_isNull4) {
/* 060 */           filter_isNull4 = false; // resultCode could change nullability.
/* 061 */           filter_value4 = inputadapter_value4 <= 10;
/* 062 */
/* 063 */         }
/* 064 */         if (!filter_isNull4 && filter_value4) {
/* 065 */         } else if (!filter_isNull1 && !filter_isNull4) {
/* 066 */           filter_value = false;
/* 067 */         } else {
/* 068 */           filter_isNull = true;
/* 069 */         }
/* 070 */       }
/* 071 */       if (filter_isNull || !filter_value) continue;
/* 072 */
/* 073 */       filter_numOutputRows.add(1);
/* 074 */
/* 075 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 076 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 077 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 078 */       Decimal inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getDecimal(1, 35, 20));
/* 079 */       project_holder.reset();
/* 080 */
/* 081 */       project_rowWriter.zeroOutNullBytes();
/* 082 */
/* 083 */       project_rowWriter.write(0, ((UTF8String) references[1]));
/* 084 */
/* 085 */       if (inputadapter_isNull) {
/* 086 */         project_rowWriter.setNullAt(1);
/* 087 */       } else {
/* 088 */         project_rowWriter.write(1, inputadapter_value);
/* 089 */       }
/* 090 */
/* 091 */       if (inputadapter_isNull1) {
/* 092 */         project_rowWriter.write(2, (Decimal) null, 35, 20);
/* 093 */       } else {
/* 094 */         project_rowWriter.write(2, inputadapter_value1, 35, 20);
/* 095 */       }
/* 096 */
/* 097 */       if (inputadapter_isNull3) {
/* 098 */         project_rowWriter.setNullAt(3);
/* 099 */       } else {
/* 100 */         project_rowWriter.write(3, inputadapter_value3);
/* 101 */       }
/* 102 */
/* 103 */       if (inputadapter_isNull4) {
/* 104 */         project_rowWriter.setNullAt(4);
/* 105 */       } else {
/* 106 */         project_rowWriter.write(4, inputadapter_value4);
/* 107 */       }
/* 108 */       project_result.setTotalSize(project_holder.totalSize());
/* 109 */       append(project_result);
/* 110 */       if (shouldStop()) return;
/* 111 */     }
/* 112 */   }
/* 113 */ }
