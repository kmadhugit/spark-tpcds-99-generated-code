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
/* 019 */   private int agg_value6;
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
/* 039 */     agg_result = new UnsafeRow(3);
/* 040 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 041 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 3);
/* 042 */
/* 043 */     agg_result1 = new UnsafeRow(3);
/* 044 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 045 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 3);
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
/* 060 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 061 */       int inputadapter_value2 = inputadapter_isNull2 ? -1 : (inputadapter_row.getInt(2));
/* 062 */
/* 063 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 064 */
/* 065 */       UnsafeRow agg_fastAggBuffer = null;
/* 066 */
/* 067 */       if (agg_fastAggBuffer == null) {
/* 068 */         // generate grouping key
/* 069 */         agg_rowWriter.zeroOutNullBytes();
/* 070 */
/* 071 */         if (inputadapter_isNull) {
/* 072 */           agg_rowWriter.setNullAt(0);
/* 073 */         } else {
/* 074 */           agg_rowWriter.write(0, inputadapter_value);
/* 075 */         }
/* 076 */
/* 077 */         if (inputadapter_isNull1) {
/* 078 */           agg_rowWriter.setNullAt(1);
/* 079 */         } else {
/* 080 */           agg_rowWriter.write(1, inputadapter_value1);
/* 081 */         }
/* 082 */
/* 083 */         if (inputadapter_isNull2) {
/* 084 */           agg_rowWriter.setNullAt(2);
/* 085 */         } else {
/* 086 */           agg_rowWriter.write(2, inputadapter_value2);
/* 087 */         }
/* 088 */         agg_value6 = 42;
/* 089 */
/* 090 */         if (!inputadapter_isNull) {
/* 091 */           agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value, agg_value6);
/* 092 */         }
/* 093 */
/* 094 */         if (!inputadapter_isNull1) {
/* 095 */           agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value1, agg_value6);
/* 096 */         }
/* 097 */
/* 098 */         if (!inputadapter_isNull2) {
/* 099 */           agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value2, agg_value6);
/* 100 */         }
/* 101 */         if (true) {
/* 102 */           // try to get the buffer from hash map
/* 103 */           agg_unsafeRowAggBuffer =
/* 104 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value6);
/* 105 */         }
/* 106 */         if (agg_unsafeRowAggBuffer == null) {
/* 107 */           if (agg_sorter == null) {
/* 108 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 109 */           } else {
/* 110 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 111 */           }
/* 112 */
/* 113 */           // the hash map had be spilled, it should have enough memory now,
/* 114 */           // try  to allocate buffer again.
/* 115 */           agg_unsafeRowAggBuffer =
/* 116 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value6);
/* 117 */           if (agg_unsafeRowAggBuffer == null) {
/* 118 */             // failed to allocate the first page
/* 119 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 120 */           }
/* 121 */         }
/* 122 */       }
/* 123 */
/* 124 */       if (agg_fastAggBuffer != null) {
/* 125 */         // update fast row
/* 126 */
/* 127 */       } else {
/* 128 */         // update unsafe row
/* 129 */
/* 130 */         // common sub-expressions
/* 131 */
/* 132 */         // evaluate aggregate function
/* 133 */
/* 134 */         // update unsafe row buffer
/* 135 */
/* 136 */       }
/* 137 */       if (shouldStop()) return;
/* 138 */     }
/* 139 */
/* 140 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 141 */   }
/* 142 */
/* 143 */   protected void processNext() throws java.io.IOException {
/* 144 */     if (!agg_initAgg) {
/* 145 */       agg_initAgg = true;
/* 146 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 147 */       agg_doAggregateWithKeys();
/* 148 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 149 */     }
/* 150 */
/* 151 */     // output the result
/* 152 */
/* 153 */     while (agg_mapIter.next()) {
/* 154 */       wholestagecodegen_numOutputRows.add(1);
/* 155 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 156 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 157 */
/* 158 */       boolean agg_isNull10 = agg_aggKey.isNullAt(0);
/* 159 */       int agg_value10 = agg_isNull10 ? -1 : (agg_aggKey.getInt(0));
/* 160 */       boolean agg_isNull11 = agg_aggKey.isNullAt(1);
/* 161 */       int agg_value11 = agg_isNull11 ? -1 : (agg_aggKey.getInt(1));
/* 162 */       boolean agg_isNull12 = agg_aggKey.isNullAt(2);
/* 163 */       int agg_value12 = agg_isNull12 ? -1 : (agg_aggKey.getInt(2));
/* 164 */       agg_rowWriter1.zeroOutNullBytes();
/* 165 */
/* 166 */       if (agg_isNull10) {
/* 167 */         agg_rowWriter1.setNullAt(0);
/* 168 */       } else {
/* 169 */         agg_rowWriter1.write(0, agg_value10);
/* 170 */       }
/* 171 */
/* 172 */       if (agg_isNull11) {
/* 173 */         agg_rowWriter1.setNullAt(1);
/* 174 */       } else {
/* 175 */         agg_rowWriter1.write(1, agg_value11);
/* 176 */       }
/* 177 */
/* 178 */       if (agg_isNull12) {
/* 179 */         agg_rowWriter1.setNullAt(2);
/* 180 */       } else {
/* 181 */         agg_rowWriter1.write(2, agg_value12);
/* 182 */       }
/* 183 */       append(agg_result1);
/* 184 */
/* 185 */       if (shouldStop()) return;
/* 186 */     }
/* 187 */
/* 188 */     agg_mapIter.close();
/* 189 */     if (agg_sorter == null) {
/* 190 */       agg_hashMap.free();
/* 191 */     }
/* 192 */   }
/* 193 */ }
