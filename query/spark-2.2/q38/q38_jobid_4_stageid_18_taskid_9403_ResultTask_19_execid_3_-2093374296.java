/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private boolean agg_initAgg;
/* 009 */   private boolean agg_bufIsNull;
/* 010 */   private long agg_bufValue;
/* 011 */   private scala.collection.Iterator inputadapter_input;
/* 012 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_numOutputRows;
/* 013 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_aggTime;
/* 014 */   private UnsafeRow agg_result;
/* 015 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 016 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 017 */   private boolean locallimit_stopEarly;
/* 018 */   private int locallimit_count;
/* 019 */   private UnsafeRow locallimit_result;
/* 020 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder locallimit_holder;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter locallimit_rowWriter;
/* 022 */   private boolean globallimit_stopEarly;
/* 023 */   private int globallimit_count;
/* 024 */   private UnsafeRow globallimit_result;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder globallimit_holder;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter globallimit_rowWriter;
/* 027 */
/* 028 */   public GeneratedIterator(Object[] references) {
/* 029 */     this.references = references;
/* 030 */   }
/* 031 */
/* 032 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 033 */     partitionIndex = index;
/* 034 */     this.inputs = inputs;
/* 035 */     agg_initAgg = false;
/* 036 */
/* 037 */     inputadapter_input = inputs[0];
/* 038 */     this.agg_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 039 */     this.agg_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 040 */     agg_result = new UnsafeRow(1);
/* 041 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 042 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 043 */     locallimit_stopEarly = false;
/* 044 */     locallimit_count = 0;
/* 045 */     locallimit_result = new UnsafeRow(1);
/* 046 */     this.locallimit_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(locallimit_result, 0);
/* 047 */     this.locallimit_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(locallimit_holder, 1);
/* 048 */     globallimit_stopEarly = false;
/* 049 */     globallimit_count = 0;
/* 050 */     globallimit_result = new UnsafeRow(1);
/* 051 */     this.globallimit_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(globallimit_result, 0);
/* 052 */     this.globallimit_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(globallimit_holder, 1);
/* 053 */
/* 054 */   }
/* 055 */
/* 056 */   private void agg_doAggregateWithoutKey() throws java.io.IOException {
/* 057 */     // initialize aggregation buffer
/* 058 */     agg_bufIsNull = false;
/* 059 */     agg_bufValue = 0L;
/* 060 */
/* 061 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 062 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 063 */       long inputadapter_value = inputadapter_row.getLong(0);
/* 064 */
/* 065 */       // do aggregate
/* 066 */       // common sub-expressions
/* 067 */
/* 068 */       // evaluate aggregate function
/* 069 */       boolean agg_isNull3 = false;
/* 070 */
/* 071 */       long agg_value3 = -1L;
/* 072 */       agg_value3 = agg_bufValue + inputadapter_value;
/* 073 */       // update aggregation buffer
/* 074 */       agg_bufIsNull = false;
/* 075 */       agg_bufValue = agg_value3;
/* 076 */       if (shouldStop()) return;
/* 077 */     }
/* 078 */
/* 079 */   }
/* 080 */
/* 081 */   @Override
/* 082 */   protected boolean stopEarly() {
/* 083 */     return globallimit_stopEarly;
/* 084 */   }
/* 085 */
/* 086 */   protected void processNext() throws java.io.IOException {
/* 087 */     while (!agg_initAgg) {
/* 088 */       agg_initAgg = true;
/* 089 */       long agg_beforeAgg = System.nanoTime();
/* 090 */       agg_doAggregateWithoutKey();
/* 091 */       agg_aggTime.add((System.nanoTime() - agg_beforeAgg) / 1000000);
/* 092 */
/* 093 */       // output the result
/* 094 */
/* 095 */       agg_numOutputRows.add(1);
/* 096 */       if (locallimit_count < 100) {
/* 097 */         locallimit_count += 1;
/* 098 */
/* 099 */         if (globallimit_count < 100) {
/* 100 */           globallimit_count += 1;
/* 101 */
/* 102 */           globallimit_rowWriter.zeroOutNullBytes();
/* 103 */
/* 104 */           if (agg_bufIsNull) {
/* 105 */             globallimit_rowWriter.setNullAt(0);
/* 106 */           } else {
/* 107 */             globallimit_rowWriter.write(0, agg_bufValue);
/* 108 */           }
/* 109 */           append(globallimit_result);
/* 110 */
/* 111 */         } else {
/* 112 */           globallimit_stopEarly = true;
/* 113 */         }
/* 114 */
/* 115 */       } else {
/* 116 */         locallimit_stopEarly = true;
/* 117 */       }
/* 118 */     }
/* 119 */   }
/* 120 */ }
