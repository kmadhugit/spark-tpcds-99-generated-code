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
/* 011 */   private boolean agg_initAgg1;
/* 012 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 013 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 014 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 015 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 016 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 017 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 018 */   private scala.collection.Iterator inputadapter_input;
/* 019 */   private UnsafeRow agg_result;
/* 020 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 022 */   private int agg_value7;
/* 023 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_numOutputRows;
/* 024 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_aggTime;
/* 025 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_numOutputRows1;
/* 026 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_aggTime1;
/* 027 */   private UnsafeRow agg_result1;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 030 */
/* 031 */   public GeneratedIterator(Object[] references) {
/* 032 */     this.references = references;
/* 033 */   }
/* 034 */
/* 035 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 036 */     partitionIndex = index;
/* 037 */     this.inputs = inputs;
/* 038 */     wholestagecodegen_init_0();
/* 039 */     wholestagecodegen_init_1();
/* 040 */
/* 041 */   }
/* 042 */
/* 043 */   private void wholestagecodegen_init_0() {
/* 044 */     agg_initAgg = false;
/* 045 */
/* 046 */     agg_initAgg1 = false;
/* 047 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 048 */
/* 049 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 050 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 051 */     inputadapter_input = inputs[0];
/* 052 */     agg_result = new UnsafeRow(3);
/* 053 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 96);
/* 054 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 3);
/* 055 */
/* 056 */     this.agg_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 057 */     this.agg_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 058 */     this.agg_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 059 */     this.agg_aggTime1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 060 */     agg_result1 = new UnsafeRow(1);
/* 061 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 062 */
/* 063 */   }
/* 064 */
/* 065 */   private void agg_doAggregateWithoutKey() throws java.io.IOException {
/* 066 */     // initialize aggregation buffer
/* 067 */     agg_bufIsNull = false;
/* 068 */     agg_bufValue = 0L;
/* 069 */
/* 070 */     if (!agg_initAgg1) {
/* 071 */       agg_initAgg1 = true;
/* 072 */       long agg_beforeAgg = System.nanoTime();
/* 073 */       agg_doAggregateWithKeys();
/* 074 */       agg_aggTime.add((System.nanoTime() - agg_beforeAgg) / 1000000);
/* 075 */     }
/* 076 */
/* 077 */     // output the result
/* 078 */
/* 079 */     while (agg_mapIter.next()) {
/* 080 */       agg_numOutputRows.add(1);
/* 081 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 082 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 083 */
/* 084 */       // do aggregate
/* 085 */       // common sub-expressions
/* 086 */
/* 087 */       // evaluate aggregate function
/* 088 */       boolean agg_isNull11 = false;
/* 089 */
/* 090 */       long agg_value11 = -1L;
/* 091 */       agg_value11 = agg_bufValue + 1L;
/* 092 */       // update aggregation buffer
/* 093 */       agg_bufIsNull = false;
/* 094 */       agg_bufValue = agg_value11;
/* 095 */
/* 096 */       if (shouldStop()) return;
/* 097 */     }
/* 098 */
/* 099 */     agg_mapIter.close();
/* 100 */     if (agg_sorter == null) {
/* 101 */       agg_hashMap.free();
/* 102 */     }
/* 103 */
/* 104 */   }
/* 105 */
/* 106 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 107 */     agg_hashMap = agg_plan.createHashMap();
/* 108 */
/* 109 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 110 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 111 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 112 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 113 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 114 */       UTF8String inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getUTF8String(1));
/* 115 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 116 */       UTF8String inputadapter_value2 = inputadapter_isNull2 ? null : (inputadapter_row.getUTF8String(2));
/* 117 */
/* 118 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 119 */
/* 120 */       UnsafeRow agg_fastAggBuffer = null;
/* 121 */
/* 122 */       if (agg_fastAggBuffer == null) {
/* 123 */         // generate grouping key
/* 124 */         agg_holder.reset();
/* 125 */
/* 126 */         agg_rowWriter.zeroOutNullBytes();
/* 127 */
/* 128 */         if (inputadapter_isNull) {
/* 129 */           agg_rowWriter.setNullAt(0);
/* 130 */         } else {
/* 131 */           agg_rowWriter.write(0, inputadapter_value);
/* 132 */         }
/* 133 */
/* 134 */         if (inputadapter_isNull1) {
/* 135 */           agg_rowWriter.setNullAt(1);
/* 136 */         } else {
/* 137 */           agg_rowWriter.write(1, inputadapter_value1);
/* 138 */         }
/* 139 */
/* 140 */         if (inputadapter_isNull2) {
/* 141 */           agg_rowWriter.setNullAt(2);
/* 142 */         } else {
/* 143 */           agg_rowWriter.write(2, inputadapter_value2);
/* 144 */         }
/* 145 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 146 */         agg_value7 = 42;
/* 147 */
/* 148 */         if (!inputadapter_isNull) {
/* 149 */           agg_value7 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value7);
/* 150 */         }
/* 151 */
/* 152 */         if (!inputadapter_isNull1) {
/* 153 */           agg_value7 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value1.getBaseObject(), inputadapter_value1.getBaseOffset(), inputadapter_value1.numBytes(), agg_value7);
/* 154 */         }
/* 155 */
/* 156 */         if (!inputadapter_isNull2) {
/* 157 */           agg_value7 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value2.getBaseObject(), inputadapter_value2.getBaseOffset(), inputadapter_value2.numBytes(), agg_value7);
/* 158 */         }
/* 159 */         if (true) {
/* 160 */           // try to get the buffer from hash map
/* 161 */           agg_unsafeRowAggBuffer =
/* 162 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value7);
/* 163 */         }
/* 164 */         if (agg_unsafeRowAggBuffer == null) {
/* 165 */           if (agg_sorter == null) {
/* 166 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 167 */           } else {
/* 168 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 169 */           }
/* 170 */
/* 171 */           // the hash map had be spilled, it should have enough memory now,
/* 172 */           // try  to allocate buffer again.
/* 173 */           agg_unsafeRowAggBuffer =
/* 174 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value7);
/* 175 */           if (agg_unsafeRowAggBuffer == null) {
/* 176 */             // failed to allocate the first page
/* 177 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 178 */           }
/* 179 */         }
/* 180 */       }
/* 181 */
/* 182 */       if (agg_fastAggBuffer != null) {
/* 183 */         // update fast row
/* 184 */
/* 185 */       } else {
/* 186 */         // update unsafe row
/* 187 */
/* 188 */         // common sub-expressions
/* 189 */
/* 190 */         // evaluate aggregate function
/* 191 */
/* 192 */         // update unsafe row buffer
/* 193 */
/* 194 */       }
/* 195 */       if (shouldStop()) return;
/* 196 */     }
/* 197 */
/* 198 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 199 */   }
/* 200 */
/* 201 */   private void wholestagecodegen_init_1() {
/* 202 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 1);
/* 203 */
/* 204 */   }
/* 205 */
/* 206 */   protected void processNext() throws java.io.IOException {
/* 207 */     while (!agg_initAgg) {
/* 208 */       agg_initAgg = true;
/* 209 */       long agg_beforeAgg1 = System.nanoTime();
/* 210 */       agg_doAggregateWithoutKey();
/* 211 */       agg_aggTime1.add((System.nanoTime() - agg_beforeAgg1) / 1000000);
/* 212 */
/* 213 */       // output the result
/* 214 */
/* 215 */       agg_numOutputRows1.add(1);
/* 216 */       agg_rowWriter1.zeroOutNullBytes();
/* 217 */
/* 218 */       if (agg_bufIsNull) {
/* 219 */         agg_rowWriter1.setNullAt(0);
/* 220 */       } else {
/* 221 */         agg_rowWriter1.write(0, agg_bufValue);
/* 222 */       }
/* 223 */       append(agg_result1);
/* 224 */     }
/* 225 */   }
/* 226 */ }
