/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private boolean agg_initAgg;
/* 009 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 010 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 011 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 012 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 013 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 014 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 015 */   private scala.collection.Iterator inputadapter_input;
/* 016 */   private UnsafeRow agg_result;
/* 017 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 018 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 019 */   private int agg_value4;
/* 020 */   private UnsafeRow agg_result1;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 023 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 024 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 025 */
/* 026 */   public GeneratedIterator(Object[] references) {
/* 027 */     this.references = references;
/* 028 */   }
/* 029 */
/* 030 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 031 */     partitionIndex = index;
/* 032 */     this.inputs = inputs;
/* 033 */     agg_initAgg = false;
/* 034 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 035 */
/* 036 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 037 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 038 */     inputadapter_input = inputs[0];
/* 039 */     agg_result = new UnsafeRow(2);
/* 040 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 041 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 2);
/* 042 */
/* 043 */     agg_result1 = new UnsafeRow(2);
/* 044 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 045 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 2);
/* 046 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 047 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 048 */
/* 049 */   }
/* 050 */
/* 051 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 052 */     agg_hashMap = agg_plan.createHashMap();
/* 053 */
/* 054 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 055 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 056 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 057 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 058 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 059 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 060 */
/* 061 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 062 */
/* 063 */       UnsafeRow agg_fastAggBuffer = null;
/* 064 */
/* 065 */       if (agg_fastAggBuffer == null) {
/* 066 */         // generate grouping key
/* 067 */         agg_rowWriter.zeroOutNullBytes();
/* 068 */
/* 069 */         if (inputadapter_isNull) {
/* 070 */           agg_rowWriter.setNullAt(0);
/* 071 */         } else {
/* 072 */           agg_rowWriter.write(0, inputadapter_value);
/* 073 */         }
/* 074 */
/* 075 */         if (inputadapter_isNull1) {
/* 076 */           agg_rowWriter.setNullAt(1);
/* 077 */         } else {
/* 078 */           agg_rowWriter.write(1, inputadapter_value1);
/* 079 */         }
/* 080 */         agg_value4 = 42;
/* 081 */
/* 082 */         if (!inputadapter_isNull) {
/* 083 */           agg_value4 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value, agg_value4);
/* 084 */         }
/* 085 */
/* 086 */         if (!inputadapter_isNull1) {
/* 087 */           agg_value4 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value1, agg_value4);
/* 088 */         }
/* 089 */         if (true) {
/* 090 */           // try to get the buffer from hash map
/* 091 */           agg_unsafeRowAggBuffer =
/* 092 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value4);
/* 093 */         }
/* 094 */         if (agg_unsafeRowAggBuffer == null) {
/* 095 */           if (agg_sorter == null) {
/* 096 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 097 */           } else {
/* 098 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 099 */           }
/* 100 */
/* 101 */           // the hash map had be spilled, it should have enough memory now,
/* 102 */           // try  to allocate buffer again.
/* 103 */           agg_unsafeRowAggBuffer =
/* 104 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value4);
/* 105 */           if (agg_unsafeRowAggBuffer == null) {
/* 106 */             // failed to allocate the first page
/* 107 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 108 */           }
/* 109 */         }
/* 110 */       }
/* 111 */
/* 112 */       if (agg_fastAggBuffer != null) {
/* 113 */         // update fast row
/* 114 */
/* 115 */       } else {
/* 116 */         // update unsafe row
/* 117 */
/* 118 */         // common sub-expressions
/* 119 */
/* 120 */         // evaluate aggregate function
/* 121 */
/* 122 */         // update unsafe row buffer
/* 123 */
/* 124 */       }
/* 125 */       if (shouldStop()) return;
/* 126 */     }
/* 127 */
/* 128 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 129 */   }
/* 130 */
/* 131 */   protected void processNext() throws java.io.IOException {
/* 132 */     if (!agg_initAgg) {
/* 133 */       agg_initAgg = true;
/* 134 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 135 */       agg_doAggregateWithKeys();
/* 136 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 137 */     }
/* 138 */
/* 139 */     // output the result
/* 140 */
/* 141 */     while (agg_mapIter.next()) {
/* 142 */       wholestagecodegen_numOutputRows.add(1);
/* 143 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 144 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 145 */
/* 146 */       boolean agg_isNull7 = agg_aggKey.isNullAt(0);
/* 147 */       int agg_value7 = agg_isNull7 ? -1 : (agg_aggKey.getInt(0));
/* 148 */       boolean agg_isNull8 = agg_aggKey.isNullAt(1);
/* 149 */       int agg_value8 = agg_isNull8 ? -1 : (agg_aggKey.getInt(1));
/* 150 */       agg_rowWriter1.zeroOutNullBytes();
/* 151 */
/* 152 */       if (agg_isNull7) {
/* 153 */         agg_rowWriter1.setNullAt(0);
/* 154 */       } else {
/* 155 */         agg_rowWriter1.write(0, agg_value7);
/* 156 */       }
/* 157 */
/* 158 */       if (agg_isNull8) {
/* 159 */         agg_rowWriter1.setNullAt(1);
/* 160 */       } else {
/* 161 */         agg_rowWriter1.write(1, agg_value8);
/* 162 */       }
/* 163 */       append(agg_result1);
/* 164 */
/* 165 */       if (shouldStop()) return;
/* 166 */     }
/* 167 */
/* 168 */     agg_mapIter.close();
/* 169 */     if (agg_sorter == null) {
/* 170 */       agg_hashMap.free();
/* 171 */     }
/* 172 */   }
/* 173 */ }
