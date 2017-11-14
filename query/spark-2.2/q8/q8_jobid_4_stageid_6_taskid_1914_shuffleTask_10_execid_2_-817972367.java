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
/* 011 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 012 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 013 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 014 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 015 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 016 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 017 */   private scala.collection.Iterator inputadapter_input;
/* 018 */   private UnsafeRow agg_result;
/* 019 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 020 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 021 */   private int agg_value4;
/* 022 */   private UnsafeRow agg_result1;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 025 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 026 */   private UnsafeRow filter_result;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 029 */   private UnsafeRow project_result;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 032 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 033 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 034 */
/* 035 */   public GeneratedIterator(Object[] references) {
/* 036 */     this.references = references;
/* 037 */   }
/* 038 */
/* 039 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 040 */     partitionIndex = index;
/* 041 */     this.inputs = inputs;
/* 042 */     wholestagecodegen_init_0();
/* 043 */     wholestagecodegen_init_1();
/* 044 */
/* 045 */   }
/* 046 */
/* 047 */   private void wholestagecodegen_init_0() {
/* 048 */     agg_initAgg = false;
/* 049 */
/* 050 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 051 */
/* 052 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 053 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 054 */     inputadapter_input = inputs[0];
/* 055 */     agg_result = new UnsafeRow(1);
/* 056 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 32);
/* 057 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 058 */
/* 059 */     agg_result1 = new UnsafeRow(2);
/* 060 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 32);
/* 061 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 2);
/* 062 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 063 */     filter_result = new UnsafeRow(2);
/* 064 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 32);
/* 065 */
/* 066 */   }
/* 067 */
/* 068 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 069 */     agg_hashMap = agg_plan.createHashMap();
/* 070 */
/* 071 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 072 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 073 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 074 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 075 */       long inputadapter_value1 = inputadapter_row.getLong(1);
/* 076 */
/* 077 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 078 */
/* 079 */       UnsafeRow agg_fastAggBuffer = null;
/* 080 */
/* 081 */       if (agg_fastAggBuffer == null) {
/* 082 */         // generate grouping key
/* 083 */         agg_holder.reset();
/* 084 */
/* 085 */         agg_rowWriter.zeroOutNullBytes();
/* 086 */
/* 087 */         if (inputadapter_isNull) {
/* 088 */           agg_rowWriter.setNullAt(0);
/* 089 */         } else {
/* 090 */           agg_rowWriter.write(0, inputadapter_value);
/* 091 */         }
/* 092 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 093 */         agg_value4 = 42;
/* 094 */
/* 095 */         if (!inputadapter_isNull) {
/* 096 */           agg_value4 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value4);
/* 097 */         }
/* 098 */         if (true) {
/* 099 */           // try to get the buffer from hash map
/* 100 */           agg_unsafeRowAggBuffer =
/* 101 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value4);
/* 102 */         }
/* 103 */         if (agg_unsafeRowAggBuffer == null) {
/* 104 */           if (agg_sorter == null) {
/* 105 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 106 */           } else {
/* 107 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 108 */           }
/* 109 */
/* 110 */           // the hash map had be spilled, it should have enough memory now,
/* 111 */           // try  to allocate buffer again.
/* 112 */           agg_unsafeRowAggBuffer =
/* 113 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value4);
/* 114 */           if (agg_unsafeRowAggBuffer == null) {
/* 115 */             // failed to allocate the first page
/* 116 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 117 */           }
/* 118 */         }
/* 119 */       }
/* 120 */
/* 121 */       if (agg_fastAggBuffer != null) {
/* 122 */         // update fast row
/* 123 */
/* 124 */       } else {
/* 125 */         // update unsafe row
/* 126 */
/* 127 */         // common sub-expressions
/* 128 */
/* 129 */         // evaluate aggregate function
/* 130 */         boolean agg_isNull5 = false;
/* 131 */
/* 132 */         long agg_value7 = agg_unsafeRowAggBuffer.getLong(0);
/* 133 */
/* 134 */         long agg_value6 = -1L;
/* 135 */         agg_value6 = agg_value7 + inputadapter_value1;
/* 136 */         // update unsafe row buffer
/* 137 */         agg_unsafeRowAggBuffer.setLong(0, agg_value6);
/* 138 */
/* 139 */       }
/* 140 */       if (shouldStop()) return;
/* 141 */     }
/* 142 */
/* 143 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 144 */   }
/* 145 */
/* 146 */   private void wholestagecodegen_init_1() {
/* 147 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 2);
/* 148 */     project_result = new UnsafeRow(1);
/* 149 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 32);
/* 150 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 1);
/* 151 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 152 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 153 */
/* 154 */   }
/* 155 */
/* 156 */   protected void processNext() throws java.io.IOException {
/* 157 */     if (!agg_initAgg) {
/* 158 */       agg_initAgg = true;
/* 159 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 160 */       agg_doAggregateWithKeys();
/* 161 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 162 */     }
/* 163 */
/* 164 */     // output the result
/* 165 */
/* 166 */     while (agg_mapIter.next()) {
/* 167 */       wholestagecodegen_numOutputRows.add(1);
/* 168 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 169 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 170 */
/* 171 */       boolean agg_isNull8 = agg_aggKey.isNullAt(0);
/* 172 */       UTF8String agg_value9 = agg_isNull8 ? null : (agg_aggKey.getUTF8String(0));
/* 173 */       long agg_value10 = agg_aggBuffer.getLong(0);
/* 174 */
/* 175 */       boolean filter_isNull = false;
/* 176 */
/* 177 */       boolean filter_value = false;
/* 178 */       filter_value = agg_value10 > 10L;
/* 179 */       if (!filter_value) continue;
/* 180 */
/* 181 */       filter_numOutputRows.add(1);
/* 182 */
/* 183 */       boolean agg_isNull11 = true;
/* 184 */       UTF8String agg_value12 = null;
/* 185 */
/* 186 */       if (!agg_isNull8) {
/* 187 */         agg_isNull11 = false; // resultCode could change nullability.
/* 188 */         agg_value12 = agg_value9.substringSQL(1, 5);
/* 189 */
/* 190 */       }
/* 191 */       project_holder.reset();
/* 192 */
/* 193 */       project_rowWriter.zeroOutNullBytes();
/* 194 */
/* 195 */       if (agg_isNull11) {
/* 196 */         project_rowWriter.setNullAt(0);
/* 197 */       } else {
/* 198 */         project_rowWriter.write(0, agg_value12);
/* 199 */       }
/* 200 */       project_result.setTotalSize(project_holder.totalSize());
/* 201 */       append(project_result);
/* 202 */
/* 203 */       if (shouldStop()) return;
/* 204 */     }
/* 205 */
/* 206 */     agg_mapIter.close();
/* 207 */     if (agg_sorter == null) {
/* 208 */       agg_hashMap.free();
/* 209 */     }
/* 210 */   }
/* 211 */ }
